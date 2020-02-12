package cn.com.hatech.sharding.config.orchestration;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.eventbus.Subscribe;
import org.apache.shardingsphere.api.config.RuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.core.config.DataSourceConfiguration;
import org.apache.shardingsphere.core.rule.MasterSlaveRule;
import org.apache.shardingsphere.core.rule.ShardingRule;
import org.apache.shardingsphere.core.yaml.engine.YamlEngine;
import org.apache.shardingsphere.orchestration.config.OrchestrationConfiguration;
import org.apache.shardingsphere.orchestration.internal.registry.RegistryCenterServiceLoader;
import org.apache.shardingsphere.orchestration.internal.registry.ShardingOrchestrationFacade;
import org.apache.shardingsphere.orchestration.internal.registry.config.event.DataSourceChangedEvent;
import org.apache.shardingsphere.orchestration.internal.registry.config.event.PropertiesChangedEvent;
import org.apache.shardingsphere.orchestration.internal.registry.config.event.ShardingRuleChangedEvent;
import org.apache.shardingsphere.orchestration.internal.registry.config.node.ConfigurationNode;
import org.apache.shardingsphere.orchestration.internal.registry.config.service.ConfigurationService;
import org.apache.shardingsphere.orchestration.internal.registry.state.event.DisabledStateChangedEvent;
import org.apache.shardingsphere.orchestration.internal.registry.state.schema.OrchestrationShardingSchema;
import org.apache.shardingsphere.orchestration.internal.rule.OrchestrationMasterSlaveRule;
import org.apache.shardingsphere.orchestration.internal.rule.OrchestrationShardingRule;
import org.apache.shardingsphere.orchestration.reg.api.RegistryCenter;
import org.apache.shardingsphere.orchestration.yaml.config.YamlDataSourceConfiguration;
import org.apache.shardingsphere.orchestration.yaml.swapper.DataSourceConfigurationYamlSwapper;
import org.apache.shardingsphere.shardingjdbc.jdbc.core.datasource.ShardingDataSource;
import org.apache.shardingsphere.shardingjdbc.orchestration.internal.datasource.AbstractOrchestrationDataSource;
import org.apache.shardingsphere.shardingjdbc.orchestration.internal.util.DataSourceConverter;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author WangMingShuai
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2020/2/12 10:57             1.0                         同创OrchestrationShardingDataSource
 * @program sharding-jdbc-demo
 * @package cn.com.hatech.sharding.config.orchestration
 * @className HatechOrchestrationShardingDataSource
 * @description 同创OrchestrationShardingDataSource
 * @create 2020/2/12 10:57
 */
public class HatechOrchestrationShardingDataSource extends AbstractOrchestrationDataSource {
    private ShardingDataSource dataSource;

    public HatechOrchestrationShardingDataSource(OrchestrationConfiguration orchestrationConfig) throws SQLException {
        super(new ShardingOrchestrationFacade(orchestrationConfig, Collections.singletonList("logic_db")));
        ConfigurationService configService = this.getShardingOrchestrationFacade().getConfigService();
        ShardingRuleConfiguration shardingRuleConfig = configService.loadShardingRuleConfiguration("logic_db");
        Preconditions.checkState(null != shardingRuleConfig && !shardingRuleConfig.getTableRuleConfigs().isEmpty(), "Missing the sharding rule configuration on registry center");

        RegistryCenter regCenter = (new RegistryCenterServiceLoader()).load(orchestrationConfig.getRegCenterConfig());
        ConfigurationNode configNode =  new ConfigurationNode(orchestrationConfig.getName());

        //修改源码类型转化异常：configService.loadDataSourceConfigurations("logic_db");
        Map<String, Map<String,Map<String,Object>>> dataSourceConfigMap = (Map<String, Map<String, Map<String, Object>>>) YamlEngine.unmarshal(regCenter.getDirectly(configNode.getDataSourcePath("logic_db")));
        Preconditions.checkState(null != dataSourceConfigMap && !dataSourceConfigMap.isEmpty(), "No available data sources to load for orchestration.");
        Map<String,YamlDataSourceConfiguration> result = Maps.newHashMap();
        for (Map.Entry<String, Map<String,Map<String,Object>>> dataSourceConfig : dataSourceConfigMap.entrySet()) {
            YamlDataSourceConfiguration yamlDataSourceConfiguration = new YamlDataSourceConfiguration();
            yamlDataSourceConfiguration.setDataSourceClassName("com.zaxxer.hikari.HikariDataSource");
            yamlDataSourceConfiguration.setProperties(dataSourceConfig.getValue().get("properties"));
            result.put(dataSourceConfig.getKey(),yamlDataSourceConfiguration);
        }

        Map<String, DataSourceConfiguration> dataSourceConfigurations =
                Maps.transformValues(result, new Function<YamlDataSourceConfiguration, DataSourceConfiguration>() {

                    @Override
                    public DataSourceConfiguration apply(final YamlDataSourceConfiguration input) {
                        return new DataSourceConfigurationYamlSwapper().swap(input);
                    }
                });
        this.dataSource = new ShardingDataSource(DataSourceConverter.getDataSourceMap(dataSourceConfigurations), new OrchestrationShardingRule(shardingRuleConfig, dataSourceConfigurations.keySet()), configService.loadProperties());
        this.initShardingOrchestrationFacade();
    }

    public HatechOrchestrationShardingDataSource(ShardingDataSource shardingDataSource, OrchestrationConfiguration orchestrationConfig) throws SQLException {
        super(new ShardingOrchestrationFacade(orchestrationConfig, Collections.singletonList("logic_db")));
        this.dataSource = new ShardingDataSource(shardingDataSource.getDataSourceMap(), new OrchestrationShardingRule(((ShardingRule)shardingDataSource.getRuntimeContext().getRule()).getRuleConfiguration(), shardingDataSource.getDataSourceMap().keySet()), shardingDataSource.getRuntimeContext().getProps().getProps());
        this.initShardingOrchestrationFacade(Collections.singletonMap("logic_db", DataSourceConverter.getDataSourceConfigurationMap(this.dataSource.getDataSourceMap())), this.getRuleConfigurationMap(), this.dataSource.getRuntimeContext().getProps().getProps());
    }

    private Map<String, RuleConfiguration> getRuleConfigurationMap() {
        Map<String, RuleConfiguration> result = new LinkedHashMap(1, 1.0F);
        result.put("logic_db", ((ShardingRule)this.dataSource.getRuntimeContext().getRule()).getRuleConfiguration());
        return result;
    }

    @Subscribe
    public final synchronized void renew(ShardingRuleChangedEvent shardingRuleChangedEvent) {
        try {
            this.dataSource = new ShardingDataSource(this.dataSource.getDataSourceMap(), new OrchestrationShardingRule(shardingRuleChangedEvent.getShardingRuleConfiguration(), this.dataSource.getDataSourceMap().keySet()), this.dataSource.getRuntimeContext().getProps().getProps());
        } catch (Throwable var3) {
            // throw var3;
        }
    }

    @Subscribe
    public final synchronized void renew(DataSourceChangedEvent dataSourceChangedEvent) {
        try {
            Map<String, DataSourceConfiguration> dataSourceConfigurations = dataSourceChangedEvent.getDataSourceConfigurations();
            this.dataSource.close(this.getDeletedDataSources(dataSourceConfigurations));
            this.dataSource.close(this.getModifiedDataSources(dataSourceConfigurations).keySet());
            this.dataSource = new ShardingDataSource(this.getChangedDataSources(this.dataSource.getDataSourceMap(), dataSourceConfigurations), (ShardingRule)this.dataSource.getRuntimeContext().getRule(), this.dataSource.getRuntimeContext().getProps().getProps());
            this.getDataSourceConfigurations().clear();
            this.getDataSourceConfigurations().putAll(dataSourceConfigurations);
        } catch (Throwable var3) {
            //throw var3;
        }
    }

    @Subscribe
    public final synchronized void renew(PropertiesChangedEvent propertiesChangedEvent) {
        try {
            this.dataSource = new ShardingDataSource(this.dataSource.getDataSourceMap(), (ShardingRule)this.dataSource.getRuntimeContext().getRule(), propertiesChangedEvent.getProps());
        } catch (Throwable var3) {
            //throw var3;
        }
    }

    @Subscribe
    public synchronized void renew(DisabledStateChangedEvent disabledStateChangedEvent) {
        OrchestrationShardingSchema shardingSchema = disabledStateChangedEvent.getShardingSchema();
        if ("logic_db".equals(shardingSchema.getSchemaName())) {
            Iterator var3 = ((ShardingRule)this.dataSource.getRuntimeContext().getRule()).getMasterSlaveRules().iterator();

            while(var3.hasNext()) {
                MasterSlaveRule each = (MasterSlaveRule)var3.next();
                ((OrchestrationMasterSlaveRule)each).updateDisabledDataSourceNames(shardingSchema.getDataSourceName(), disabledStateChangedEvent.isDisabled());
            }
        }

    }

    @Override
    protected ShardingDataSource getDataSource() {
        return this.dataSource;
    }
}

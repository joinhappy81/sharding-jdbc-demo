package cn.com.hatech.sharding.config;

import org.apache.shardingsphere.orchestration.config.OrchestrationConfiguration;
import org.apache.shardingsphere.orchestration.reg.api.RegistryCenterConfiguration;
import org.apache.shardingsphere.shardingjdbc.orchestration.api.OrchestrationShardingDataSourceFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @Program: mswang-sharding-jdbc
 * @Package: com.mswang.learn.config.datasource
 * @ClassName: DynamicDataSourceConfig
 * @Description: 使用ShardingJdbc配置动态数据源
 * @Author: WangMingShuai
 * @Create: 2020/1/3 14:34
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2020/1/3 14:34             1.0                         使用ShardingJdbc配置动态数据源
 */
@Configuration
public class DataSourceConfig {

    @Bean("shardingDataSource")
    public DataSource shardingDataSource() throws SQLException {
        RegistryCenterConfiguration regConfig = new RegistryCenterConfiguration("zookeeper");
        regConfig.setServerLists("192.168.0.118:2181");
        regConfig.setNamespace("orchestration-sharding-namespace");
        OrchestrationConfiguration orchConfig = new OrchestrationConfiguration("orchestration-sharding-data-source", regConfig,false);
        // 获取数据源对象
        return OrchestrationShardingDataSourceFactory.createDataSource(orchConfig);
    }

    @Primary
    @Bean("dataSource")
    public DataSource dataSource(@Qualifier("shardingDataSource") DataSource shardingDataSource) {
        return shardingDataSource;
    }

}

package cn.com.hatech.sharding.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @Program: mswang-sharding-jdbc
 * @Package: com.mswang.learn.config
 * @ClassName: MybatisPlusPageConfig
 * @Description: MybatisPlus 分页配置
 * @Author: WangMingShuai
 * @Create: 2020/1/3 13:59
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2020/1/3 13:59             1.0                         MybatisPlus 分页配置
 */
@Configuration
public class MybatisPlusPageConfig {

    /**
     * MybatisPlus 分页配置
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}

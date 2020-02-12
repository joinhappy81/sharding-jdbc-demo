package cn.com.hatech.sharding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @Program: sharding-jdbc-demo
 * @Package: cn.com.hatech.sharding
 * @ClassName: ShardingMasterSlaveApplication
 * @Description: sharding 读写分离
 * @Author: WangMingShuai
 * @Create: 2020/1/9 9:16
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2020/1/9 9:16             1.0                         sharding 水平分表
 */
@SpringBootApplication
public class ShardingMasterSlaveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingMasterSlaveApplication.class,args);
    }
}

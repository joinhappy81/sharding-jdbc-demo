package cn.com.hatech.sharding.server.mapper;

import cn.com.hatech.sharding.common.base.IBaseMapper;
import cn.com.hatech.sharding.server.entity.OrderPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @Program: sharding-jdbc-demo
 * @Package: cn.com.hatech.sharding.server.mapper
 * @ClassName: IOrderMapper
 * @Description: 订单表
 * @Author: WangMingShuai
 * @Create: 2020/1/9 9:42
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2020/1/9 9:42             1.0                         订单表
 */
@Mapper
public interface IOrderMapper extends IBaseMapper<OrderPo> {
}

package cn.com.hatech.sharding.server.mapper;

import cn.com.hatech.sharding.common.base.IBaseMapper;
import cn.com.hatech.sharding.server.entity.StorePo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @Program: sharding-jdbc-demo
 * @Package: cn.com.hatech.sharding.order.mapper
 * @ClassName: IStoreMapper
 * @Description: 店铺数据层
 * @Author: WangMingShuai
 * @Create: 2020/1/9 14:22
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2020/1/9 14:22             1.0                         店铺数据层
 */
@Mapper
public interface IStoreMapper extends IBaseMapper<StorePo> {
}

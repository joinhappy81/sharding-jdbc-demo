package cn.com.hatech.sharding.server.mapper;

import cn.com.hatech.sharding.common.base.IBaseMapper;
import cn.com.hatech.sharding.server.entity.DictPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @Program: sharding-jdbc-demo
 * @Package: cn.com.hatech.sharding.server.mapper
 * @ClassName: IDictMapper
 * @Description: 字典表
 * @Author: WangMingShuai
 * @Create: 2020/1/9 15:38
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2020/1/9 15:38             1.0                         字典表
 */
@Mapper
public interface IDictMapper extends IBaseMapper<DictPo> {
}

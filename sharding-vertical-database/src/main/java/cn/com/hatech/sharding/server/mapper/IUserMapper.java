package cn.com.hatech.sharding.server.mapper;

import cn.com.hatech.sharding.common.base.IBaseMapper;
import cn.com.hatech.sharding.server.entity.UserPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @Program: sharding-jdbc-demo
 * @Package: cn.com.hatech.sharding.server.mapper
 * @ClassName: IUserMapper
 * @Description: 用户数据层
 * @Author: WangMingShuai
 * @Create: 2020/1/9 9:42
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2020/1/9 9:42             1.0                         用户数据层
 */
@Mapper
public interface IUserMapper extends IBaseMapper<UserPo> {
}

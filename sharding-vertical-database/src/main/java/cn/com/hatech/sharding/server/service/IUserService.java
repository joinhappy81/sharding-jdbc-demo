package cn.com.hatech.sharding.server.service;

import cn.com.hatech.sharding.common.base.IBaseService;
import cn.com.hatech.sharding.server.entity.UserPo;

import java.util.List;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @Program: sharding-jdbc-demo
 * @Package: cn.com.hatech.sharding.server.service
 * @ClassName: IUserService
 * @Description: 用户业务接口
 * @Author: WangMingShuai
 * @Create: 2020/1/9 9:43
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2020/1/9 9:43             1.0                         用户业务接口
 */
public interface IUserService extends IBaseService<UserPo> {

    List<UserPo> findAll();
}

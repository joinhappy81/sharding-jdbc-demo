package cn.com.hatech.sharding.server.service.impl;

import cn.com.hatech.sharding.common.base.AbstractService;
import cn.com.hatech.sharding.server.entity.UserPo;
import cn.com.hatech.sharding.server.mapper.IUserMapper;
import cn.com.hatech.sharding.server.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @Program: sharding-jdbc-demo
 * @Package: cn.com.hatech.sharding.server.service.impl
 * @ClassName: UserServiceImpl
 * @Description: 用户业务接口实现
 * @Author: WangMingShuai
 * @Create: 2020/1/9 9:44
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2020/1/9 9:44             1.0                         用户业务接口实现
 */
@Service("orderService")
public class UserServiceImpl extends AbstractService<UserPo> implements IUserService {

    @Resource
    private IUserMapper orderMapper;

    @Override
    public List<UserPo> findAll() {
        QueryWrapper<UserPo> queryWrapper = new QueryWrapper<>();
        return orderMapper.selectList(queryWrapper);
    }
}

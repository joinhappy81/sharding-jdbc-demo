package cn.com.hatech.sharding.server.service.impl;

import cn.com.hatech.sharding.common.base.AbstractService;
import cn.com.hatech.sharding.server.entity.OrderPo;
import cn.com.hatech.sharding.server.mapper.IOrderMapper;
import cn.com.hatech.sharding.server.service.IOrderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @Program: sharding-jdbc-demo
 * @Package: cn.com.hatech.sharding.server.service.impl
 * @ClassName: OrderServiceImpl
 * @Description: 订单业务接口实现
 * @Author: WangMingShuai
 * @Create: 2020/1/9 9:44
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2020/1/9 9:44             1.0                         订单业务接口实现
 */
@Service("orderService")
public class OrderServiceImpl extends AbstractService<OrderPo> implements IOrderService {

    @Resource
    private IOrderMapper orderMapper;

    @Override
    public List<OrderPo> findAll(Long orderId, Long userId) {
        QueryWrapper<OrderPo> queryWrapper = new QueryWrapper<>();
        if (orderId != null) {
            queryWrapper.eq("order_id",orderId);
        }
        if (userId != null) {
            queryWrapper.eq("user_id",userId);
        }
        return orderMapper.selectList(queryWrapper);
    }
}

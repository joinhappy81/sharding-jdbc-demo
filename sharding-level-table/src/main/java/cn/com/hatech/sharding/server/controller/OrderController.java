package cn.com.hatech.sharding.server.controller;

import cn.com.hatech.sharding.common.result.ResponseObject;
import cn.com.hatech.sharding.common.result.ResponseResult;
import cn.com.hatech.sharding.server.entity.OrderPo;
import cn.com.hatech.sharding.server.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @Program: sharding-jdbc-demo
 * @Package: cn.com.hatech.sharding.server.controller
 * @ClassName: OrderController
 * @Description: 订单控制层
 * @Author: WangMingShuai
 * @Create: 2020/1/9 12:31
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2020/1/9 12:31             1.0                         订单控制层
 */
@Slf4j
@Api(value = "cn.com.hatech.sharding.server.controller.OrderController", tags = {"订单管理"})
@RestController
@RequestMapping("/order")
public class OrderController {

    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @ApiOperation(value="新增订单(水平分表)",httpMethod="POST",notes="批量生成20个订单")
    @PostMapping("/insert")
    public ResponseObject insert() {
        for (int i = 0; i < 5; i++) {
            OrderPo orderPo = OrderPo
                    .builder()
                    .price(new BigDecimal(11*i))
                    .userId((long)i)
                    .status("Finish").build();
            orderService.insert(orderPo);
        }
        return ResponseResult.success("新增成功",null);
    }


    @ApiOperation(value="订单查询(水平分表)",httpMethod="POST",notes="根据订单id查询订单信息")
    @PostMapping("/list")
    public ResponseObject list (Long orderId) {
        List<OrderPo> list = orderService.findAll(orderId);
        return ResponseResult.success("查询成功",list);
    }
}

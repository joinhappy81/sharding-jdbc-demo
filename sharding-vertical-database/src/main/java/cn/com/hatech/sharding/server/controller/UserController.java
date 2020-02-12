package cn.com.hatech.sharding.server.controller;

import cn.com.hatech.sharding.common.result.ResponseObject;
import cn.com.hatech.sharding.common.result.ResponseResult;
import cn.com.hatech.sharding.server.entity.UserPo;
import cn.com.hatech.sharding.server.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @Program: sharding-jdbc-demo
 * @Package: cn.com.hatech.sharding.server.controller
 * @ClassName: UserController
 * @Description: 用户控制层
 * @Author: WangMingShuai
 * @Create: 2020/1/9 12:31
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2020/1/9 12:31             1.0                         用户控制层
 */
@Slf4j
@Api(value = "cn.com.hatech.sharding.server.controller.UserController", tags = {"用户管理"})
@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService orderService;

    public UserController(IUserService orderService) {
        this.orderService = orderService;
    }

    @ApiOperation(value="新增用户(垂直分库)",httpMethod="POST",notes="根据参数添加用户")
    @PostMapping("/insert")
    public ResponseObject insert(@ApiParam @RequestBody UserPo userPo) {
        orderService.insert(userPo);
        return ResponseResult.success("新增成功",null);
    }

    @ApiOperation(value="用户查询(垂直分库)",httpMethod="POST",notes="查询全部用户信息")
    @PostMapping("/list")
    public ResponseObject list () {
        List<UserPo> list = orderService.findAll();
        return ResponseResult.success("查询成功",list);
    }

}

package cn.com.hatech.sharding.server.controller;

import cn.com.hatech.sharding.common.result.ResponseObject;
import cn.com.hatech.sharding.common.result.ResponseResult;
import cn.com.hatech.sharding.server.entity.StorePo;
import cn.com.hatech.sharding.server.service.IStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @Program: sharding-jdbc-demo
 * @Package: cn.com.hatech.sharding.order.controller
 * @ClassName: StoreController
 * @Description: 店铺控制层
 * @Author: WangMingShuai
 * @Create: 2020/1/9 14:25
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2020/1/9 14:25             1.0                         店铺控制层
 */
@Slf4j
@Api(value = "cn.com.hatech.sharding.server.controller.StoreController", tags = {"店铺管理"})
@RestController
@RequestMapping("/store")
public class StoreController {

    private final IStoreService storeService;

    public StoreController(IStoreService storeService) {
        this.storeService = storeService;
    }

    @ApiOperation(value="新增店铺(水平分库)",httpMethod="POST",notes="批量生成5个店铺")
    @PostMapping("/insert")
    public ResponseObject insert() {
        for (int i = 0; i < 5; i++) {
            StorePo orderPo = StorePo
                    .builder()
                    .areaId((long)i)
                    .name("店铺"+i).build();
            storeService.insert(orderPo);
        }
        return ResponseResult.success("新增成功",null);
    }

    @ApiOperation(value="店铺查询(水平分库)",httpMethod="POST",notes="根据区域id查询店铺信息")
    @PostMapping("/list")
    public ResponseObject list (Long areaId) {
        List<StorePo> list = storeService.findAll(areaId);
        return ResponseResult.success("查询成功",list);
    }

}

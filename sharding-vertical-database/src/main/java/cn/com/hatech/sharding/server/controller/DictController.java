package cn.com.hatech.sharding.server.controller;

import cn.com.hatech.sharding.common.result.ResponseObject;
import cn.com.hatech.sharding.common.result.ResponseResult;
import cn.com.hatech.sharding.server.entity.DictPo;
import cn.com.hatech.sharding.server.entity.StorePo;
import cn.com.hatech.sharding.server.entity.UserPo;
import cn.com.hatech.sharding.server.service.IDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @Program: sharding-jdbc-demo
 * @Package: cn.com.hatech.sharding.server.controller
 * @ClassName: DictController
 * @Description: 字典表控制层
 * @Author: WangMingShuai
 * @Create: 2020/1/9 15:40
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2020/1/9 15:40             1.0                         字典表控制层
 */
@Slf4j
@Api(value = "cn.com.hatech.sharding.server.controller.DictController", tags = {"字典管理"})
@RestController
@RequestMapping("/dict")
public class DictController {

    private final IDictService dictService;

    public DictController(IDictService dictService) {
        this.dictService = dictService;
    }

    @ApiOperation(value="字典查询(公共表)",httpMethod="POST",notes="查询全部用户信息")
    @PostMapping("/list")
    public ResponseObject list () {
        List<DictPo> list = dictService.findAll();
        return ResponseResult.success("查询成功",list);
    }

    @ApiOperation(value="新增字典(公共表)",httpMethod="POST",notes="批量添加5个字典信息")
    @PostMapping("/insert")
    public ResponseObject insert() {
        for (int i = 0; i< 5; i++) {

            DictPo dictPo = DictPo.builder()
                    .code("code00_"+i)
                    .type("type"+i)
                    .value("value-"+i).build();

            dictService.insert(dictPo);
        }
        return ResponseResult.success("新增成功",null);
    }
}

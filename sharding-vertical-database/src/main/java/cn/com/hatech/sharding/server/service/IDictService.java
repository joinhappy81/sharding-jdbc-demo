package cn.com.hatech.sharding.server.service;

import cn.com.hatech.sharding.common.base.IBaseService;
import cn.com.hatech.sharding.server.entity.DictPo;

import java.util.List;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @Program: sharding-jdbc-demo
 * @Package: cn.com.hatech.sharding.server.service
 * @ClassName: IDictSer
 * @Description: 字典表
 * @Author: WangMingShuai
 * @Create: 2020/1/9 15:38
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2020/1/9 15:38             1.0                         字典表
 */
public interface IDictService extends IBaseService<DictPo> {
    List<DictPo> findAll();
}

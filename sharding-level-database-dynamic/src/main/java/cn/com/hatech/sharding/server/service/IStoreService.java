package cn.com.hatech.sharding.server.service;

import cn.com.hatech.sharding.common.base.IBaseService;
import cn.com.hatech.sharding.server.entity.StorePageDto;
import cn.com.hatech.sharding.server.entity.StorePo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @Program: sharding-jdbc-demo
 * @Package: cn.com.hatech.sharding.order.service
 * @ClassName: IStoreService
 * @Description: 店铺业务接口
 * @Author: WangMingShuai
 * @Create: 2020/1/9 14:23
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2020/1/9 14:23             1.0                         店铺业务接口
 */
public interface IStoreService extends IBaseService<StorePo> {

    List<StorePo> findAll(Long areaId);

    Page<StorePo> findPage(StorePageDto storePageDto);
}

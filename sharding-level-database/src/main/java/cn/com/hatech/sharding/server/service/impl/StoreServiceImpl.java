package cn.com.hatech.sharding.server.service.impl;

import cn.com.hatech.sharding.common.base.AbstractService;
import cn.com.hatech.sharding.server.entity.StorePo;
import cn.com.hatech.sharding.server.mapper.IStoreMapper;
import cn.com.hatech.sharding.server.service.IStoreService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @Program: sharding-jdbc-demo
 * @Package: cn.com.hatech.sharding.order.service.impl
 * @ClassName: StoreServiceImpl
 * @Description: 店铺业务接口实现
 * @Author: WangMingShuai
 * @Create: 2020/1/9 14:24
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2020/1/9 14:24             1.0                         店铺业务接口实现
 */
@Service("storeService")
public class StoreServiceImpl extends AbstractService<StorePo> implements IStoreService {

    @Resource
    private IStoreMapper storeMapper;
    @Override
    public List<StorePo> findAll(Long areaId) {
        QueryWrapper<StorePo> queryWrapper = new QueryWrapper<StorePo>();
        if (areaId != null) {
            queryWrapper.eq("area_id",areaId);
        }
        return storeMapper.selectList(queryWrapper);
    }
}

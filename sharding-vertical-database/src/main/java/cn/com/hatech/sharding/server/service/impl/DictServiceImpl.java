package cn.com.hatech.sharding.server.service.impl;

import cn.com.hatech.sharding.common.base.AbstractService;
import cn.com.hatech.sharding.server.entity.DictPo;
import cn.com.hatech.sharding.server.mapper.IDictMapper;
import cn.com.hatech.sharding.server.service.IDictService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @Program: sharding-jdbc-demo
 * @Package: cn.com.hatech.sharding.server.service.impl
 * @ClassName: DictServiceImpl
 * @Description: 字典表
 * @Author: WangMingShuai
 * @Create: 2020/1/9 15:39
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2020/1/9 15:39             1.0                         字典表
 */
@Service("dictService")
public class DictServiceImpl extends AbstractService<DictPo> implements IDictService {

    @Resource
    private IDictMapper dictMapper;

    @Override
    public List<DictPo> findAll() {
        QueryWrapper<DictPo> queryWrapper = new QueryWrapper<>();
        return dictMapper.selectList(queryWrapper);
    }
}

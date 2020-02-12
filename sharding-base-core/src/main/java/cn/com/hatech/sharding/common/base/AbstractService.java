package cn.com.hatech.sharding.common.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @Program: hatech-framework
 * @Package: cn.com.hatechframework.data.universal
 * @ClassName: AbstractService
 * @Description: 通用MyBatis-Plus Mapper插件的抽象接口实现类
 * @Author: JiangXincan
 * @Create: 2019/12/18 10:37
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * Jiangxincan         2019/12/18 10:37             1.0                         通用MyBatis-Plus Mapper插件的抽象接口实现类
 */
public abstract class AbstractService<T> implements IBaseService<T> {

    @Autowired
    protected IBaseMapper<T> baseMapper;

    /**
     * @param model 将要添加的对象数据
     * @Description: 添加对象信息
     * @Param <T>       数据类型
     * @Author: JiangXincan
     * @Date: 2019/12/18 10:55
     * @return: java.lang.Integer
     */
    @SuppressWarnings("unchecked")
    @Override
    public Integer insert(T model) {
        return baseMapper.insert(model);
    }

    /**
     * @param id 将要删除的数据ID
     * @Description: 根据ID删除对象信息
     * @Author: JiangXincan
     * @Date: 2019/12/18 10:55
     * @return: java.lang.Integer
     */
    @SuppressWarnings("unchecked")
    @Override
    public Integer deleteById(String id) {
        return baseMapper.deleteById(id);
    }

    /**
     * @param model 将要更新的对象数据
     * @Description: 更新对象信息
     * @Param <T>       数据类型
     * @Author: JiangXincan
     * @Date: 2019/12/18 10:55
     * @return: int
     */
    @SuppressWarnings("unchecked")
    @Override
    public int update(T model) {
        return baseMapper.updateById(model);
    }

    /**
     * @param id 将要查询的数据ID
     * @Description: 根据ID查询对象信息
     * @Author: JiangXincan
     * @Date: 2019/12/18 10:55
     * @return: T
     */
    @SuppressWarnings("unchecked")
    @Override
    public T selectById(String id) {
        return baseMapper.selectById(id);
    }

    /**
     * @param ids 将要删除的数据ID
     * @Description: 根据一批数据ID删除对应的数据信息
     * <font>扩展函数</font>
     * eg：传入的ids -> “1,2,3,4”
     * @Author: JiangXincan
     * @Date: 2019/12/18 10:55
     * @return: java.lang.Integer
     */
    @SuppressWarnings("unchecked")
    @Override
    public Integer deleteByIds(String ids) {
        Collection list = Arrays.asList(ids.split(","));
        return baseMapper.deleteBatchIds(list);
    }

    /**
     * @param ids 将要查询的数据ID
     * @Description: 根据一批数据ID查询对应的数据信息
     * <font>扩展函数</font>
     * eg：传入的ids -> “1,2,3,4”
     * @Author: JiangXincan
     * @Date: 2019/12/18 10:55
     * @return: java.util.List<T>
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<T> selectListByIds(String ids) {
        ids = "'" + ids.replace(",", "','") + "'";
        Collection<? extends Serializable> list = Arrays.asList(ids.split(","));
        return baseMapper.selectBatchIds(list);
    }

    /**
     * @Description: 查询所有对象信息
     * <font>扩展函数</font>
     * @Author: JiangXincan
     * @Date: 2019/12/18 10:55
     * @return: java.util.List<T>
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<T> selectAll() {
        return baseMapper.selectList(null);
    }

    /**
     * @param model 将要更新的对象数据
     * @Description: 根据实体类查询对象信息
     * <font>扩展函数</font>
     * @Author: JiangXincan
     * @Date: 2019/12/18 10:55
     * @return: java.util.List<T>
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<T> select(T model) {
        QueryWrapper<T> wrapper = new QueryWrapper<>(model);
        return baseMapper.selectList(wrapper);
    }

    /**
     * @param model 将要更新的对象数据
     * @Description: 根据实体类查询对象信息
     * <font>扩展函数</font>
     * @Author: JiangXincan
     * @Date: 2019/12/18 10:55
     * @return: <T>
     */
    @SuppressWarnings("unchecked")
    @Override
    public T selectOne(T model) {
        QueryWrapper<T> wrapper = new QueryWrapper<>(model);
        return baseMapper.selectOne(wrapper);
    }

}

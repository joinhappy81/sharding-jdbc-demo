package cn.com.hatech.sharding.common.base;

import java.util.List;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @Program: hatech-framework
 * @Package: cn.com.hatechframework.data.universal
 * @ClassName: IBaseService
 * @Description: MyBatisPlus基础接口层
 * @Author: JiangXincan
 * @Create: 2019/12/18 10:41
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * Jiangxincan         2019/12/18 10:41             1.0                         MyBatisPlus基础接口层
 */
public interface IBaseService<T> {

    /**
     *
     * @Description: 添加对象信息
     *
     * @param model     将要添加的对象数据
     * @Param <T>       数据类型
     * @Author: JiangXincan
     * @Date: 2019/12/18 10:55
     * @return: java.lang.Integer
     */
    Integer insert(T model);

    /**
     *
     * @Description: 根据ID删除对象信息
     *
     * @param id 将要删除的数据ID
     * @Author: JiangXincan
     * @Date: 2019/12/18 10:55
     * @return: java.lang.Integer
     */
    Integer deleteById(String id);

    /**
     *
     * @Description: 更新对象信息
     *
     * @param model     将要更新的对象数据
     * @Param <T>       数据类型
     * @Author: JiangXincan
     * @Date: 2019/12/18 10:55
     * @return: int
     */
    int update(T model);

    /**
     *
     * @Description: 根据ID查询对象信息
     *
     * @param id 将要查询的数据ID
     * @Author: JiangXincan
     * @Date: 2019/12/18 10:55
     * @return: T
     */
    T selectById(String id);

    /**
     *
     * @Description: 根据一批数据ID删除对应的数据信息
     *  <font>扩展函数</font>
     *  eg：传入的ids -> “1,2,3,4”
     *
     * @param ids 将要删除的数据ID
     * @Author: JiangXincan
     * @Date: 2019/12/18 10:55
     * @return: java.lang.Integer
     */
    Integer deleteByIds(String ids);

    /**
     *
     * @Description: 根据一批数据ID查询对应的数据信息
     *  <font>扩展函数</font>
     *  eg：传入的ids -> “1,2,3,4”
     *
     * @param ids 将要查询的数据ID
     * @Author: JiangXincan
     * @Date: 2019/12/18 10:55
     * @return: java.util.List<T>
     */
    List<T> selectListByIds(String ids);

    /**
     *
     * @Description: 查询所有对象信息
     * <font>扩展函数</font>
     *
     * @Author: JiangXincan
     * @Date: 2019/12/18 10:55
     * @return: java.util.List<T>
     */
    List<T> selectAll();

    /**
     *
     * @Description: 根据实体类查询对象信息
     * <font>扩展函数</font>
     *
     * @Author: JiangXincan
     * @Date: 2019/12/18 10:55
     * @return: java.util.List<T>
     */
    List<T> select(T record);

    /**
     *
     * @Description: 根据实体类查询对象信息
     * <font>扩展函数</font>
     *
     * @Author: JiangXincan
     * @Date: 2019/12/18 10:55
     * @return: <T>
     */
    T selectOne(T record);

}

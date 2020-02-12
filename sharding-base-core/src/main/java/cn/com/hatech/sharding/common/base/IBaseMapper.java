package cn.com.hatech.sharding.common.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @Program: hatech-framework
 * @Package: cn.com.hatechframework.data.universal
 * @ClassName: IBaseMapper
 * @Description: 基础实现MyBatisPlus BaseMapper数据访问层接口
 * @Author: JiangXincan
 * @Create: 2019/12/18 10:43
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * Jiangxincan         2019/12/18 10:43             1.0                         基础实现MyBatisPlus BaseMapper数据访问层接口
 */
@Component
public interface IBaseMapper<T> extends BaseMapper<T> {
}

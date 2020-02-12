package cn.com.hatech.sharding.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @Program: sharding-jdbc-demo
 * @Package: cn.com.hatech.sharding.order.entity
 * @ClassName: StorePo
 * @Description: 店铺实体类
 * @Author: WangMingShuai
 * @Create: 2020/1/9 14:07
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2020/1/9 14:07             1.0                         店铺实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_store")
public class StorePo {

    @TableId(value = "store_id",type = IdType.ID_WORKER)
    private Long storeId;

    @TableField("name")
    private String name;

    @TableField("area_id")
    private Long areaId;
}

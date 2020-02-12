package cn.com.hatech.sharding.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @Program: sharding-jdbc-demo
 * @Package: cn.com.hatech.sharding.server.entity
 * @ClassName: OrderPo
 * @Description: 订单实体类
 * @Author: WangMingShuai
 * @Create: 2020/1/9 9:42
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2020/1/9 9:42             1.0                         订单实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_order")
public class OrderPo {

    @TableId(value = "order_id",type = IdType.ID_WORKER)
    private Long orderId;

    @TableField("price")
    private BigDecimal price;

    @TableField("user_id")
    private Long userId;

    @TableField("status")
    private String status;
}

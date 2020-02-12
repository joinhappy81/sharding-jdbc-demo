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
 * @ClassName: UserPo
 * @Description: 用户实体类
 * @Author: WangMingShuai
 * @Create: 2020/1/9 9:42
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2020/1/9 9:42             1.0                         用户实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_user")
public class UserPo {

    @TableId(value = "user_id",type = IdType.ID_WORKER)
    private Long userId;

    @TableField("full_name")
    private String fullName;

    @TableField("user_type")
    private String user_type;
}

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
 * @Package: cn.com.hatech.sharding.server.entity
 * @ClassName: DictPo
 * @Description: 字典表
 * @Author: WangMingShuai
 * @Create: 2020/1/9 15:35
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2020/1/9 15:35             1.0                         字典表
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_dict")
public class DictPo {

    @TableId(value = "dict_id",type = IdType.ID_WORKER)
    private Long dictId;

    @TableField("type")
    private String type;

    @TableField("code")
    private String code;

    @TableField("value")
    private String value;
}

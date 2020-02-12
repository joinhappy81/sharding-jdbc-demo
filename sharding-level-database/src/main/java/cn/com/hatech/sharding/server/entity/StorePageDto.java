package cn.com.hatech.sharding.server.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author WangMingShuai
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2020/2/12 20:32             1.0                         店铺分页查询实体类
 * @program sharding-jdbc-demo
 * @package cn.com.hatech.sharding.server.entity
 * @className StorePageDTO
 * @description 店铺分页查询实体类
 * @create 2020/2/12 20:32
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StorePageDto {

    @ApiModelProperty(value="当前页数,为空时，默认从第1页开始", dataType = "Integer", example = "1")
    @DecimalMin(message = "当前页数错误,应当大于等于于{value}一页", value = "1")
    private Integer page = 1;

    @ApiModelProperty(value="每页条数，为空时，默认每页提供10条数据", dataType = "Integer", example = "10")
    @NotNull(message = "每页条数不能为空")
    @DecimalMin(message = "每页条数错误,应当大于等于于{value}条", value = "1")
    private Integer limit = 10;

    @ApiModelProperty(value="店铺名称", dataType = "String", example = "店铺列表查询")
    private String name;
}

package cn.com.hatech.sharding.common.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @Program: hatech-framework
 * @Package: cn.com.hatechframework.data.page
 * @ClassName: PaginationQuery
 * @Description: 分页查询公用处理类
 * @Author: JiangXincan
 * @Create: 2019/12/19 13:15
 * @Version: 1.0
 */
@ApiModel(value = "cn.com.hatechframework.data.page.PaginationQuery", description = "操作日志实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationQuery{

    @ApiModelProperty(value="当前页数,为空时，默认从第1页开始", dataType = "Integer", example = "1")
    @DecimalMin(message = "当前页数错误,应当大于等于于{value}一页", value = "1")
    private Integer page;

    @ApiModelProperty(value="每页条数，为空时，默认每页提供10条数据", dataType = "Integer", example = "10")
    @NotNull(message = "每页条数不能为空")
    @DecimalMin(message = "每页条数错误,应当大于等于于{value}条", value = "1")
    private Integer limit;

}

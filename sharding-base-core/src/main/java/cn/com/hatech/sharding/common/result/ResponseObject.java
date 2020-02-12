package cn.com.hatech.sharding.common.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @Program: hatech-framework
 * @Package: cn.com.hatechframework.utils.response
 * @ClassName: ResponseObject<T>
 * @Description: 响应结果实体类
 * @Author: JiangXincan
 * @Create: 2019/12/18 9:43
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * Jiangxincan         2019/12/18 9:43             1.0                         响应结果实体类
 */
@ApiModel(value = "cn.com.hatechframework.utils.response.ResponseObject<T>",description = "状态返回信息")
public class ResponseObject<T> {

    @ApiModelProperty(name="code", value="响应结果编码")
    private Integer code;

    @ApiModelProperty(name="msg", value="响应结果信息")
    private String msg;

    @ApiModelProperty(name="count",value="统计列表总数（如果列表存在）")
    private long count;

    @ApiModelProperty(name="data",value="响应结果数据")
    private T data;

    @ApiModelProperty(name="data",value="响应结果时间")
    private String time;

    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        time = sdf.format(new Date().getTime());
    }

    public ResponseObject(){}

    public ResponseObject(ResponseCode responseCode){
        this.code = responseCode.code();
        this.msg = responseCode.message();
    }

    public ResponseObject(ResponseCode responseCode, long count, T data){
        this.code = responseCode.code();
        this.msg = responseCode.message();
        this.count = count;
        this.data = data;
    }

    public ResponseObject<T> code(ResponseCode responseCode) {
        this.code = responseCode.code();
        this.msg = responseCode.message();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public long getCount() {
        return count;
    }

    public T getData() {
        return data;
    }

    public String getTime() {
        return time;
    }

    public ResponseObject<T> code(int code) {
        this.code = code;
        return this;
    }


    public ResponseObject<T> msg(String msg) {
        this.msg = msg;
        return this;
    }

    public ResponseObject<T> count(long count) {
        this.count = count;
        return this;
    }

    public ResponseObject<T> data(T data) {
        this.data = data;
        return this;
    }

    public ResponseObject<T> time(String time) {
        this.time = time;
        return this;
    }
}

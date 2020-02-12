package cn.com.hatech.sharding.common.exception;

import cn.com.hatech.sharding.common.result.ResponseCode;
import lombok.Getter;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @Program: hatech-framework
 * @Package: cn.com.hatechframework.config.exception
 * @ClassName: BusinessException
 * @Description: 自定义业务异常
 * @Author: WangMingShuai
 * @Create: 2019/12/20 17:03
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2019/12/20 17:03             1.0                         自定义业务异常
 */
@Getter
public class BusinessException extends RuntimeException {

    private final Integer code;

    /**
     * @Description: 自定义业务异常
     * @param errorCode  响应状态枚举类
     * @Author: WangMingShuai
     * @Date: 2019/12/24 16:16
     * @return:
     */
    public BusinessException(ResponseCode errorCode) {
      super(errorCode.message());
      this.code = errorCode.code();
    }

    /**
     * @Description: 自定义业务异常
     * @param code  异常码
     * @param message  异常码描述
     * @Author: WangMingShuai
     * @Date: 2019/12/24 16:17
     * @return:
     */
    public BusinessException(Integer code, String message) {
      super(message);
      this.code = code;
    }

}

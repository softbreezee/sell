package com.softbreezee.demo.exception;

import com.softbreezee.demo.enums.ResultEnum;
import lombok.Getter;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.exception
 * @date:2018/6/30
 */
@Getter
public class SellException extends RuntimeException {
    private Integer code;
    private String msg;
    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
    public SellException(Integer code,String msg) {
        super(msg);
        this.code = code;
    }

}

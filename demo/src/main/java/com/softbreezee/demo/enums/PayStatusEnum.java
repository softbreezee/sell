package com.softbreezee.demo.enums;

import lombok.Getter;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.enums
 * @date:2018/6/30
 */
@Getter
public enum PayStatusEnum implements CodeEnum {
    WAIT(0,"待支付"),
    SUCCESS(1,"支付成功"),
    ;
    private Integer code;
    private String msg;
    PayStatusEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
}

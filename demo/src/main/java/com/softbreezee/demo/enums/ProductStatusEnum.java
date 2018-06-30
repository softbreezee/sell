package com.softbreezee.demo.enums;

import lombok.Getter;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.enums
 * @date:2018/6/29
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"上架"),
    DOWN(1,"下架");
    private Integer code;
    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

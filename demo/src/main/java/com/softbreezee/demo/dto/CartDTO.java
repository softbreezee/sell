package com.softbreezee.demo.dto;

import lombok.Data;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.dto 用来传输前台的数据
 * @date:2018/6/30
 */
@Data
public class CartDTO {
    private String productId;
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public CartDTO() {
    }
}

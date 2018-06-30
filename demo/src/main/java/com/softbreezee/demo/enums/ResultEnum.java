package com.softbreezee.demo.enums;

import lombok.Getter;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.enums
 * @date:2018/6/30
 */
@Getter
public enum ResultEnum {
    PARAM_ERROR(1, "参数不正确"),
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"库存不足"),
    ORDER_NOT_EXIST(12,"订单不存在" ),
    ORDERDETAIL_NOT_EXIST(13,"无订单详情" ),
    ORDER_STATUS_ERROR(14,"订单状态不正确"),
    ORDER_UPDATE_FAIL(15, "订单更新失败"),
    ORDER_DETAIL_EMPTY(16,"订单详情为空" ),
    ORDER_PAY_STATUS_ERROR(17,"订单支付不正确" ),
    CART_EMPTY(18, "购物车为空"),
            ;
    private Integer code;
    private String msg;
    ResultEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

}
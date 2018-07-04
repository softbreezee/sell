package com.softbreezee.demo.enums;

import lombok.Getter;
import sun.print.ServiceDialog;

import javax.management.loading.MLetContent;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.enums
 * @date:2018/6/30
 */
@Getter
public enum ResultEnum {
    SUCCESS(0, "成功"),
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
    ORDER_OWNER_ERROR(19, "该订单不属于当前用户"),
    WECHAT_MP_ERROR(20,"微信公众号方面错误"),
    ORDER_CANCEL_SUCCESS(22,"订单取消成功"),
    ORDER_FINISH_SUCCESS(23,"订单完结成功"),
    PRODUCT_STATUS_ERROR(24,"商品状态不正确") ;
    ;
    private Integer code;
    private String msg;
    ResultEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

}

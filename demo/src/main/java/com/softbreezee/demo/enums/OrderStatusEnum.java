package com.softbreezee.demo.enums;

import lombok.Getter;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.enums
 * @date:2018/6/30
 */
@Getter
public enum OrderStatusEnum  implements   CodeEnum{
    NEW(0,"待支付"),
    FINISHED(1,"完成支付"),
    CANCEL(2,"已取消"),
    ;

    private Integer code;
    private String msg;


    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

//    public OrderStatusEnum getOrderStatusEnum(Integer code){
//
//        for(OrderStatusEnum orderStatusEnum:OrderStatusEnum.values()){
//            if(orderStatusEnum.code == code){
//                return orderStatusEnum;
//            }
//        }
//        return null;
//    }
}

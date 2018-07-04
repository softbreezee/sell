package com.softbreezee.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.softbreezee.demo.dataobj.OrderDetail;
import com.softbreezee.demo.enums.OrderStatusEnum;
import com.softbreezee.demo.enums.PayStatusEnum;
import com.softbreezee.demo.utils.EnumUtil;
import com.softbreezee.demo.utils.serializer.Date2LongSerilalizer;
import lombok.Data;
import org.aspectj.weaver.ast.Or;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.dto
 * @date:2018/6/30
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    /**订单id */
    private String orderId;

    /**  买家名字. */
    private String buyerName;

    /** 买家手机号.*/
    private String buyerPhone;

    /** 买家地址.*/
    private String buyerAddress;

    /**买家微信Openid.*/
    private String buyerOpenid;

    /** 订单总金额.*/
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. */
    private Integer orderStatus;

    /**支付状态, 默认为0未支付.*/
    private Integer payStatus;

    /** 创建时间.*/
    @JsonSerialize(using = Date2LongSerilalizer.class)
    private Date createTime;

    /**更新时间.*/
    @JsonSerialize(using = Date2LongSerilalizer.class)
    private Date updateTime;

    /** 订单详情 */
    private List<OrderDetail>orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }
    @JsonIgnore
    public PayStatusEnum getpayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }
}

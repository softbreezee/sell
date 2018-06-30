package com.softbreezee.demo.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.form 用于表单验证
 * @date:2018/6/30
 */
@Data
public class OrderForm {
    @NotEmpty(message = "姓名必填")
    private String name;
    @NotEmpty(message = "手机号必填")
    private String phone;
    @NotEmpty(message = "地址必填")
    private String address;
    @NotEmpty(message = "openid必填")
    private String openid;
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
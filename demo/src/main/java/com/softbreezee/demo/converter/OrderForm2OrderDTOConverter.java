package com.softbreezee.demo.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.softbreezee.demo.dataobj.OrderDetail;
import com.softbreezee.demo.dto.OrderDTO;
import com.softbreezee.demo.enums.ResultEnum;
import com.softbreezee.demo.exception.SellException;
import com.softbreezee.demo.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.converter
 * @date:2018/6/30
 */
@Slf4j
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm){
        OrderDTO orderDTO = new OrderDTO();
        Gson gson = new Gson();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        String itemsStr = orderForm.getItems();
        //googel的json工具
        List<OrderDetail> orderDetails = new ArrayList<>();
        try {
            orderDetails = gson.fromJson(itemsStr,new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误，string={}",itemsStr);
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetails);

        return orderDTO;
    }

}

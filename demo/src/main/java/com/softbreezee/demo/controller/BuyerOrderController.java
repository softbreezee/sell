package com.softbreezee.demo.controller;

import com.softbreezee.demo.converter.OrderForm2OrderDTOConverter;
import com.softbreezee.demo.dto.OrderDTO;
import com.softbreezee.demo.enums.ResultEnum;
import com.softbreezee.demo.exception.SellException;
import com.softbreezee.demo.form.OrderForm;
import com.softbreezee.demo.service.OrderService;
import com.softbreezee.demo.utils.ResultVOUtil;
import com.softbreezee.demo.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.controller 买家controller
 * @date:2018/6/30
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;

    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String,String>> createOrder(@Valid OrderForm orderForm,
                                                    BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确，orderForm={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode()
                    ,bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车不能空，");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO returnOrderDTO = orderService.create(orderDTO);

        Map<String,String > map = new HashMap<>();
        map.put("orderId",returnOrderDTO.getOrderId());
        return ResultVOUtil.success(map);



    }

    //订单列表

    //订单详情

    //取消订单

}

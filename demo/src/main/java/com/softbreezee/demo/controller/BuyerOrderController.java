package com.softbreezee.demo.controller;

import com.softbreezee.demo.converter.OrderForm2OrderDTOConverter;
import com.softbreezee.demo.dto.OrderDTO;
import com.softbreezee.demo.enums.ResultEnum;
import com.softbreezee.demo.exception.SellException;
import com.softbreezee.demo.form.OrderForm;
import com.softbreezee.demo.repository.OrderDetailRepository;
import com.softbreezee.demo.service.BuyerService;
import com.softbreezee.demo.service.OrderService;
import com.softbreezee.demo.utils.ResultVOUtil;
import com.softbreezee.demo.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
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

    @Autowired
    private BuyerService buyerService;
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
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page",defaultValue = "0") Integer page,
                                         @RequestParam(value = "size",defaultValue = "10") Integer size){
        if(StringUtils.isEmpty(openid)){
            log.error("【查询订单列表为空】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest request = PageRequest.of(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid,request);
        //Date -> long

        return ResultVOUtil.success(orderDTOPage.getContent());
    }


    //订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId){
//        if (StringUtils.isEmpty(openid)){
//            log.error("【订单详情】openid为空");
//            throw new SellException(ResultEnum.PARAM_ERROR);
//        }
//        if (StringUtils.isEmpty(orderId)){
//            log.error("【订单详情】orderId为空");
//            throw new SellException(ResultEnum.PARAM_ERROR);
//        }
       OrderDTO orderDTO =  buyerService.findOrderOne(orderId,openid);
        return ResultVOUtil.success(orderDTO);

    }

    //取消订单
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId){
        buyerService.cancelOrder(orderId,openid);
        return ResultVOUtil.success(null);
    }
}

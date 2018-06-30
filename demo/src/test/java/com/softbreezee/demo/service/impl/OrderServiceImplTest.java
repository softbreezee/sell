package com.softbreezee.demo.service.impl;

import com.softbreezee.demo.dataobj.OrderDetail;
import com.softbreezee.demo.dto.OrderDTO;
import org.aspectj.weaver.ast.Or;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.service.impl
 * @date:2018/6/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {
    private String openId = "110110";

    private final Logger logger = LoggerFactory.getLogger(OrderServiceImplTest.class);
    @Autowired
    private OrderServiceImpl orderService;
    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("lolood");
        orderDTO.setBuyerAddress("武汉 洪山");
        orderDTO.setBuyerPhone("18576649086");
        orderDTO.setBuyerOpenid(openId);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("12312");
        o1.setProductQuantity(1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("123123");
        o2.setProductQuantity(2);

        orderDetailList.add(o1);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        logger.info("【创建订单】result={}", result);
    }

    @Test
    public void findOne() {
        OrderDTO orderDT = orderService.findOne("1234567");
        Assert.assertEquals(1,orderDT.getOrderDetailList().size());
    }

    @Test
    public void findList() {
        PageRequest pageRequest = new PageRequest(1,3);
        Page<OrderDTO> orderDTOPage = orderService.findList("110110",pageRequest);
        assertEquals(0,orderDTOPage.getContent().size());
        assertEquals(3,orderDTOPage.getTotalElements());
    }

    @Test
    public void findAll() {
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne("1530327962266171271");
        OrderDTO updateResult = orderService.cancel(orderDTO);
        assertEquals(2,updateResult.getOrderStatus().intValue());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne("1530327962266171271");
        OrderDTO updateResult = orderService.finish(orderDTO);
        assertEquals(1,updateResult.getOrderStatus().intValue());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne("1530327962266171271");
        OrderDTO updateResult = orderService.paid(orderDTO);
        assertEquals(1,updateResult.getPayStatus().intValue());
    }
}
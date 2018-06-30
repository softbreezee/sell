package com.softbreezee.demo.service;

import com.softbreezee.demo.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.service
 * @date:2018/6/30
 */
public interface OrderService {
    /**
     * 创建订单
     * @param orderDTO 这是一个不同于entity的，专门用来传输的一个类，有和OrderMaster一样的属性，但是多一个list表示orderdetail。另这里没有维护的关系，设计数据库的时候，没有将orderdetail与ordermaster联系起来！
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /** 查询单个订单*/
    OrderDTO findOne(String orderId);

    /** 根据openID 查询 */
    Page<OrderDTO> findList(String buyerOpenId, Pageable pageable);
    Page<OrderDTO> findAll(Pageable pageable);

    /** 取消订单，只有对新订单有用 */
    OrderDTO cancel(OrderDTO orderDTO);
    /** 完结支付，只有对新订单有用 */
    OrderDTO finish(OrderDTO orderDTO);
    /** 支付订单 */
    OrderDTO paid(OrderDTO orderDTO);




}

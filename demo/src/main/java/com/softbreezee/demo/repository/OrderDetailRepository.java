package com.softbreezee.demo.repository;

import com.softbreezee.demo.dataobj.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.repository
 * @date:2018/6/30
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrderId(String orderId);
}

package com.softbreezee.demo.repository;

import com.softbreezee.demo.dataobj.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.repository
 * @date:2018/6/30
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
    //通过买家openid查找该买家的订单，同时考虑分页
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}

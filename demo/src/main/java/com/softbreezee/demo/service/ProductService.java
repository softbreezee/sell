package com.softbreezee.demo.service;

import com.softbreezee.demo.dataobj.ProductInfo;
import com.softbreezee.demo.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.service
 * @date:2018/6/29
 */
public interface ProductService {
    ProductInfo save(ProductInfo productInfo);
    Page<ProductInfo> findAll(Pageable pageable);
    ProductInfo findOne(String productId);
    /**
     * 查询在架商品
     * @return
     */
    List<ProductInfo> findUpAll();

    //加库存
    void increaseStock(List<CartDTO> cartDTOS);
    //减库存
    void decreaseStock(List<CartDTO> cartDTOS);


}

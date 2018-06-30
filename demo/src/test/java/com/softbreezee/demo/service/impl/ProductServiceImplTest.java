package com.softbreezee.demo.service.impl;

import com.softbreezee.demo.dataobj.ProductInfo;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.service.impl
 * @date:2018/6/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void save() {
        ProductInfo productInfo = productService.findOne("123123456456");
        productInfo.setProductIcon("www.xx.com");
        ProductInfo productInfo1 = productService.save(productInfo);
        assertEquals("milk",productInfo1.getProductName());
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<ProductInfo> list = productService.findAll(pageRequest);
        System.out.println(list.getTotalElements());
    }

    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne("123123456456");
        assertEquals("milk",productInfo.getProductName());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productService.findUpAll();
        assertEquals(1,list.size());
    }
}
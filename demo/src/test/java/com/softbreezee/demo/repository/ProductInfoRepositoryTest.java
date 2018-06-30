package com.softbreezee.demo.repository;

import com.softbreezee.demo.dataobj.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.repository
 * @date:2018/6/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();

        productInfo.setProductId("123123456456");
        productInfo.setProductName("milk");
        productInfo.setProductPrice(new BigDecimal(5.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("good milk");
        productInfo.setProductIcon("http://aa.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);

        ProductInfo result = productInfoRepository.save(productInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByProductStatusIs() {
       List<ProductInfo> list =  productInfoRepository.findByProductStatusIs(0);
        assertNotEquals(0,list.size());
       List<ProductInfo> list1 =  productInfoRepository.findByProductStatusIs(1);
        assertEquals(0,list1.size());
    }
}
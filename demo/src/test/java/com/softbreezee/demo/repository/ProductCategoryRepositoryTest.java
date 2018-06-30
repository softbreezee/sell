package com.softbreezee.demo.repository;

import com.softbreezee.demo.dataobj.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
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
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> list1 = productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertEquals(1,list1.size());
    }

    @Test
    public void findOne(){
        ProductCategory productCategory = productCategoryRepository.findById(1).get();
        System.out.println(productCategory.getCategoryName());
    }

    @Test
    public void update(){
        ProductCategory productCategory = productCategoryRepository.findById(1).get();
        productCategory.setCategoryName("短途");
        productCategory.setCategoryType(8);
        productCategoryRepository.save(productCategory);
    }

    @Test
    public void save(){
        ProductCategory productCategory = new ProductCategory("长途",2);
        productCategoryRepository.save(productCategory);
    }
}
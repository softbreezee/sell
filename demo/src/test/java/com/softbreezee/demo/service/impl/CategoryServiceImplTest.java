package com.softbreezee.demo.service.impl;

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
 * @description: com.softbreezee.demo.service.impl
 * @date:2018/6/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;
    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(1);
        System.out.println(productCategory.getCategoryName());
//        Assert.assertNotNull(productCategory);
    }

    @Test
    public void finAll() {
        List<ProductCategory> list = categoryService.finAll();
        assertNotEquals(0,list.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(1,2,3,4);
        List<ProductCategory> list1 = categoryService.findByCategoryTypeIn(list);
        assertNotEquals(0,list1.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("热卖",1);
        ProductCategory pc = categoryService.save(productCategory);
        Assert.assertNotNull(pc);
    }
}
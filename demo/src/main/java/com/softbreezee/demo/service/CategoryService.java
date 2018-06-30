package com.softbreezee.demo.service;

import com.softbreezee.demo.dataobj.ProductCategory;

import java.util.List;

/**
 * 商品类目service
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> finAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);


}

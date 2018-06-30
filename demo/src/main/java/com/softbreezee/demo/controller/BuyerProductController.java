package com.softbreezee.demo.controller;

import com.softbreezee.demo.dataobj.ProductCategory;
import com.softbreezee.demo.dataobj.ProductInfo;
import com.softbreezee.demo.service.CategoryService;
import com.softbreezee.demo.service.ProductService;
import com.softbreezee.demo.utils.ResultVOUtil;
import com.softbreezee.demo.vo.ProductInfoVO;
import com.softbreezee.demo.vo.ProductVO;
import com.softbreezee.demo.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.controller
 * @date:2018/6/29
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){

        //查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
//        List<Integer> categoryTypeList = new ArrayList<>();
//        for(ProductInfo productInfo:productList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        //查询类目
        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(categoryTypeList);
        //数据拼装
        List<ProductVO> productVOList =new ArrayList<>();
        for(ProductCategory productCategory:productCategories){
           ProductVO productVO = new ProductVO();
           productVO.setCategoryName(productCategory.getCategoryName());
           productVO.setCategoryType(productCategory.getCategoryType());
           List<ProductInfoVO> productInfoVOList = new ArrayList<>();
           for(ProductInfo productInfo:productInfoList){
               if(productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                   ProductInfoVO productInfoVO = new ProductInfoVO();
                   BeanUtils.copyProperties(productInfo,productInfoVO);
                   productInfoVOList.add(productInfoVO);
               }
           }
           productVO.setProductInfoVOList(productInfoVOList);
           productVOList.add(productVO);
        }
        return   ResultVOUtil.success(productVOList);
    }

}

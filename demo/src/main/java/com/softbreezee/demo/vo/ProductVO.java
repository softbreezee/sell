package com.softbreezee.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.vo 商品类目
 * @date:2018/6/29
 */
@Data
public class ProductVO {
    //因为controller返回的是json,这里将对象序列化的时候返回给前端就是name
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}

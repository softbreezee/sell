package com.softbreezee.demo.vo;

import lombok.Data;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.vo http请求返回最外层对象
 * @date:2018/6/29
 */
@Data
public class ResultVO<T> {
    private Integer code;//错误码
    private String msg;//提示信息
    private T data;//具体内容
}

package com.softbreezee.demo.utils;

import com.softbreezee.demo.vo.ResultVO;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.utils
 * @date:2018/6/29
 */
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg("成功");
        resultVO.setCode(0);
        resultVO.setData(object);
        return resultVO;
    }
    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg(msg);
        resultVO.setCode(code);
        return resultVO;
    }
}

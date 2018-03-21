package com.soft.classwork.utils;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResultUtil {
    private final static Logger logger= LoggerFactory.getLogger(ResultUtil.class);
    public static Result success(Object object){
        logger.debug("**************************成功输出***************************");
        Result result = new Result();
        result.setCode("0000");
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }
    public static Result Error(String code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result Error(ResultEnum resultEnum) {
        return Error(resultEnum.getCode(), resultEnum.getMsg());
    }
}

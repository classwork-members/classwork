package com.soft.classwork.handle;

import com.soft.classwork.exception.PetException;
import com.soft.classwork.model.Result;
import com.soft.classwork.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof PetException){
            PetException petException = (PetException) e;
            return ResultUtil.Error(petException.getCode(),petException.getMessage());
        }
        return ResultUtil.Error("2000",e.getMessage());
    }
}

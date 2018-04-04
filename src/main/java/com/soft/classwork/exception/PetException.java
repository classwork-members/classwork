package com.soft.classwork.exception;

import com.soft.classwork.enums.LXHEnum;
import com.soft.classwork.enums.ResultEnum;

public class PetException extends RuntimeException{
    private String code;

    public PetException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public PetException(LXHEnum lxhEnum){
        super(lxhEnum.getMsg());
        this.code = lxhEnum.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}

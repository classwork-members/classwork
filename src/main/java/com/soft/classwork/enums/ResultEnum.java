package com.soft.classwork.enums;

public enum ResultEnum {
    UNKOWN_ERROR("1000","未知错误"),
    NONTASK_ERROR("0001","该条任务不存在，请先添加"),
    SUCCESS("0000","成功"),
    UPDATE_FAIL("0002","更新失败"),
    ;
    private String code;
    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

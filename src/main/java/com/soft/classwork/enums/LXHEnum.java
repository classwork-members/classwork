package com.soft.classwork.enums;

public enum LXHEnum {
    DEPT_ID("1001","deptid不能为0"),
    ;
    private String code;
    private String msg;

    LXHEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

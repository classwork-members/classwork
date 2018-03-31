package com.soft.classwork.enums;

public enum ResultEnum {
    UNKOWN_ERROR("1000","未知错误"),
    NONTASK_ERROR("0001","该条任务不存在，请先添加"),
    SUCCESS("0000","成功"),
    UPDATE_FAIL("0002","更新失败"),
    REGISTER_FAIL1("0003","该用户已存在，注册失败。"),
    REGISTER_FAIL2("0004","注册失败。"),
    INSERT_FAIL("0005","插入数据失败。"),
    GETDARA_FAIL("0006","获取数据失败。"),
    USER_NULL("0007","该用户不存在。"),
    DELETE_USER_FAIL("0008","删除用户失败。"),
    DELETE_USERROLE_FAIL("0009","删除用户-角色失败。"),
    ROLE_DATA_FAIL("0010","获取role数据失败"),
    USER_DATA_FAIL("0011","获取user数据失败"),
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

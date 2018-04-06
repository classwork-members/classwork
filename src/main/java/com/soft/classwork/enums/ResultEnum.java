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
    REQUEST_NULL("0012","传入参数为空"),
    DEPT_NAME("0013","departmentName不能为空"),
    INSERT_DEPT("0014","新增科室失败"),
    INSERT_DEPT1("0015","该科室已存在，请勿重复插入"),
    DEPT_ID("0016","deptid不能为空"),
    DEPT_PRIN("0017","principalArr不能为空。"),
    ILLNESS_NAME("0018","illness name 不能为空。"),
    ILLNESS_IN_TIME("0019","illness in time 不能为空"),
    ADD_HOS_INFO("0020","添加入院信息失败"),
    HOS_ID("0021","hospitalized id 不能为空"),
    UPDATE_HOS_FAIL("0022","更新住院信息失败。"),
    DELETE_HOS_FAIL("0023","删除住院信息失败。"),
    DRUG_ID_NULL("0024","drug id 不能为空"),
    DRUG_NAME_NULL("0025","drug name 不能为空"),
    DRUG_FEE_NULL("0026","drug fee 不能为负数。"),
    ADD_DRUG_FAIL("0027","新增drug失败。"),
    UPDADE_DRUG_FAIL("0028","更新drug失败。"),
    DELETE_DRUG_FAIL("0029","删除drug失败。"),
    DRUG_NAME_EXIT("0030","该药品信息已经存在，请勿重复插入"),
    INFO_NOT_EXIT("0031","该条数据不存在，删除无效"),
    DELETE_DEPT_FAIL("0032","删除科室失败。"),
    UPDATE_DEPT_FAIL("0033","更新科室失败。"),
    CHARGE_PAYMENT_NULL("0034","charge parment不能小于0"),
    CHARGE_PURPOSE_NULL("0035","charge purpose不能为空"),
    DELETE_FAIL("0036","删除失败"),
    DATA_EXIT("0037","该数据已存在，请勿重复插入。"),
    UPDATE_DATA_NONEXIT("0038","该数据不存在，请先新建"),
    CHARGE_ID_NULL("0039","charge id 不能为空。"),
    ASSAY_ID_NULL("0040","assay id不能为空"),
    ASSAY_NAME_NULL("0041","assay name不能为空"),
    ASSAY_DEPARTMENT_NULL("0042","assay department不能为空"),
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
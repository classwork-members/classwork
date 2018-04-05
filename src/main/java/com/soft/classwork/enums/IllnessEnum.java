package com.soft.classwork.enums;

/**
 * Created by Yuukiiii
 * on 2018/4/2 18:39
 */


public enum IllnessEnum {
    QWR("7","犬瘟热"),
    QXXBD("8","犬细小病毒"),
    HCB("9","蛔虫病"),
    GCB("10","钩虫病"),
    KY("11","口炎"),
    CY("12","肠炎"),
    CBM("13","肠便秘"),
    ZQGY("14","支气管炎"),
    FY("15","肺炎"),
    TNB("16","糖尿病"),
    WS("17","外伤"),
    WKGR("18","外科感染"),
    JNZ("19","间囊肿"),
    JY("20","绝育"),
    PFC("21","破腹产")
    ;
    private String id;
    private String name;

    IllnessEnum(String id,String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static String getNameById(String id) {
        for (IllnessEnum illnessEnum : IllnessEnum.values()) {
            if (illnessEnum.getId() == id) {
                return illnessEnum.name;
            }
        }
        return null;
    }
}

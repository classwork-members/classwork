package com.soft.classwork.model;

public class Drug {
    private int drugid;
    private String drugname;
    private String drugfee;
    private String drugdesc;//药品描述

    public int getDrugid() {
        return drugid;
    }

    public void setDrugid(int drugid) {
        this.drugid = drugid;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public String getDrugfee() {
        return drugfee;
    }

    public void setDrugfee(String drugfee) {
        this.drugfee = drugfee;
    }

    public String getDrugdesc() {
        return drugdesc;
    }

    public void setDrugdesc(String drugdesc) {
        this.drugdesc = drugdesc;
    }
}

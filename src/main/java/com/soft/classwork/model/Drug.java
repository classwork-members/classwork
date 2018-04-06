package com.soft.classwork.model;

public class Drug {
    private int drugid;
    private String drugname;
    private float drugfee;
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

    public float getDrugfee() {
        return drugfee;
    }

    public void setDrugfee(float drugfee) {
        this.drugfee = drugfee;
    }

    public String getDrugdesc() {
        return drugdesc;
    }

    public void setDrugdesc(String drugdesc) {
        this.drugdesc = drugdesc;
    }
}

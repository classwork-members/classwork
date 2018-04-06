package com.soft.classwork.model;

public class Charge {
    private int chargeid;
    private String payment;
    private String purpose;
    private String dt_create;
    private String dt_update;

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public int getChargeid() {
        return chargeid;
    }

    public void setChargeid(int chargeid) {
        this.chargeid = chargeid;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDt_create() {
        return dt_create;
    }

    public void setDt_create(String dt_create) {
        this.dt_create = dt_create;
    }

    public String getDt_update() {
        return dt_update;
    }

    public void setDt_update(String dt_update) {
        this.dt_update = dt_update;
    }
}

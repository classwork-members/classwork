package com.soft.classwork.model;

public class Charge {
    private int chargeid;
    private String payment;
    private String usage;
    private String dt_create;
    private String dt_update;

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

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
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

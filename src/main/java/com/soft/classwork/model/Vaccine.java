package com.soft.classwork.model;

public class Vaccine {
    private int vaccineid;
    private String vaccinename;
    private String purpose;
    private String fee;

    public int getVaccineid() {
        return vaccineid;
    }

    public void setVaccineid(int vaccineid) {
        this.vaccineid = vaccineid;
    }

    public String getVaccinename() {
        return vaccinename;
    }

    public void setVaccinename(String vaccinename) {
        this.vaccinename = vaccinename;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}

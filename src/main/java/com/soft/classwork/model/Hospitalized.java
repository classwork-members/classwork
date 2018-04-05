package com.soft.classwork.model;

public class Hospitalized {
    private int hospitalizedid;
    private String dt_in_hospital;
    private String dt_out_hospital;
    private String illnessname;

    public int getHospitalizedid() {
        return hospitalizedid;
    }

    public void setHospitalizedid(int hospitalizedid) {
        this.hospitalizedid = hospitalizedid;
    }

    public String getDt_in_hospital() {
        return dt_in_hospital;
    }

    public void setDt_in_hospital(String dt_in_hospital) {
        this.dt_in_hospital = dt_in_hospital;
    }

    public String getDt_out_hospital() {
        return dt_out_hospital;
    }

    public void setDt_out_hospital(String de_out_hospital) {
        this.dt_out_hospital = de_out_hospital;
    }

    public String getIllnessname() {
        return illnessname;
    }

    public void setIllnessname(String illnessname) {
        this.illnessname = illnessname;
    }
}

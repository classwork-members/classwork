package com.soft.classwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cases {

  @Id
  @GeneratedValue
  private Integer caseid;

  private String casename;
  private String illnessid;


  public Integer getCaseid() {
    return caseid;
  }

  public void setCaseid(Integer caseid) {
    this.caseid = caseid;
  }


  public String getCasename() {
    return casename;
  }

  public void setCasename(String casename) {
    this.casename = casename;
  }


  public String getIllnessid() {
    return illnessid;
  }

  public void setIllnessid(String illnessid) {
    this.illnessid = illnessid;
  }

}

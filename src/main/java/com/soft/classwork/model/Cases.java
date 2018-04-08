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
  private Integer illnessid;
  private String casedate;

  public Cases(String casename, Integer illnessid, String casedate) {
    this.casename = casename;
    this.illnessid = illnessid;
    this.casedate = casedate;
  }

  public String getCasedate() {
    return casedate;
  }

  public void setCasedate(String casedate) {
    this.casedate = casedate;
  }



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


  public Integer getIllnessid() {
    return illnessid;
  }

  public void setIllnessid(Integer illnessid) {
    this.illnessid = illnessid;
  }

}
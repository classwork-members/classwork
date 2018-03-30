package com.soft.classwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Cases {

  @Id
  @GeneratedValue
  private Integer caseid;

  private String casename;
  private Integer illnessid;

  public Timestamp getCasedate() {
    return casedate;
  }

  public void setCasedate(Timestamp casedate) {
    this.casedate = casedate;
  }

  private Timestamp casedate;


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

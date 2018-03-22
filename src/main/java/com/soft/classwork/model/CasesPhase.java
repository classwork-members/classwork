package com.soft.classwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CasesPhase {

  @Id
  @GeneratedValue
  private Integer casephaseid;
  private Integer caseid;
  private String casephasename;
  private String dataid;


  public Integer getCasephaseid() {
    return casephaseid;
  }

  public void setCasephaseid(Integer casephaseid) {
    this.casephaseid = casephaseid;
  }


  public Integer getCaseid() {
    return caseid;
  }

  public void setCaseid(Integer caseid) {
    this.caseid = caseid;
  }


  public String getCasephasename() {
    return casephasename;
  }

  public void setCasephasename(String casephasename) {
    this.casephasename = casephasename;
  }


  public String getDataid() {
    return dataid;
  }

  public void setDataid(String dataid) {
    this.dataid = dataid;
  }

}

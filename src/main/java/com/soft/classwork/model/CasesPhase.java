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
  private Integer dataid;
  //private Integer phasetypeid;

//  public Integer getPhasetypeid() {
//    return phasetypeid;
//  }
//
//  public void setPhasetypeid(Integer phasetypeid) {
//    this.phasetypeid = phasetypeid;
//  }


  public CasesPhase(Integer caseid, String casephasename, Integer dataid) {
    this.caseid = caseid;
    this.casephasename = casephasename;
    this.dataid = dataid;
  }

  public CasesPhase() {
  }

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


  public Integer getDataid() {
    return dataid;
  }

  public void setDataid(Integer dataid) {
    this.dataid = dataid;
  }

}

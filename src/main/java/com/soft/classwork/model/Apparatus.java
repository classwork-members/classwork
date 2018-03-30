package com.soft.classwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Apparatus {
    @Id
    @GeneratedValue
  private Integer appaid;
  private String appadesc;
  private String appaname;


  public Integer getAppaid() {
    return appaid;
  }

  public void setAppaid(Integer appaid) {
    this.appaid = appaid;
  }


  public String getAppadesc() {
    return appadesc;
  }

  public void setAppadesc(String appadesc) {
    this.appadesc = appadesc;
  }


  public String getAppaname() {
    return appaname;
  }

  public void setAppaname(String appaname) {
    this.appaname = appaname;
  }

}

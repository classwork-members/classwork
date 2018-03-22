package com.soft.classwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Illness {

  @Id
  @GeneratedValue
  private Integer illnessid;
  private String illnessname;
  private String parentid;


  public Integer getIllnessid() {
    return illnessid;
  }

  public void setIllnessid(Integer illnessid) {
    this.illnessid = illnessid;
  }


  public String getIllnessname() {
    return illnessname;
  }

  public void setIllnessname(String illnessname) {
    this.illnessname = illnessname;
  }


  public String getParentid() {
    return parentid;
  }

  public void setParentid(String parentid) {
    this.parentid = parentid;
  }

}

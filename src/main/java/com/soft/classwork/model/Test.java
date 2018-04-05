package com.soft.classwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Test {

  @Id
  @GeneratedValue
  private Integer testid;

  private Timestamp testtime;
  private String testname;
  private Integer illnessid;


  public Integer getTestid() {
    return testid;
  }

  public void setTestid(Integer testid) {
    this.testid = testid;
  }


  public Timestamp getTesttime() {
    return testtime;
  }

  public void setTesttime(Timestamp testtime) {
    this.testtime = testtime;
  }


  public String getTestname() {
    return testname;
  }

  public void setTestname(String testname) {
    this.testname = testname;
  }


  public Integer getIllnessid() {
    return illnessid;
  }

  public void setIllnessid(Integer illnessid) {
    this.illnessid = illnessid;
  }

}

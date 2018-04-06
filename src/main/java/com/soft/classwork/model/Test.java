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
  private Integer testtime;
  private String testname;
  private Integer illnessid;
  private Integer totalscore;
  private Integer examcount;

  public Integer getTestid() {
    return testid;
  }

  public void setTestid(Integer testid) {
    this.testid = testid;
  }


  public Integer getTesttime() {
    return testtime;
  }

  public void setTesttime(Integer testtime) {
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

  public Integer getTotalscore() {
    return totalscore;
  }

  public void setTotalscore(Integer totalscore) {
    this.totalscore = totalscore;
  }

  public Integer getExamcount() {
    return examcount;
  }

  public void setExamcount(Integer examcount) {
    this.examcount = examcount;
  }

  @Override
  public String toString() {
    return "Test{" +
            "testid=" + testid +
            ", testtime=" + testtime +
            ", testname='" + testname + '\'' +
            ", illnessid=" + illnessid +
            ", totalscore=" + totalscore +
            ", examcount=" + examcount +
            '}';
  }
}

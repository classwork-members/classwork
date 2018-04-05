package com.soft.classwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class UserTest {

  @Id
  @GeneratedValue
  private Integer userTestid;
  private Integer testid;
  private Timestamp testtime;
  private Integer grade;
  private Integer userid;


  public Integer getUserTestid() {
    return userTestid;
  }

  public void setUserTestid(Integer userTestid) {
    this.userTestid = userTestid;
  }


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


  public Integer getGrade() {
    return grade;
  }

  public void setGrade(Integer grade) {
    this.grade = grade;
  }


  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }

}

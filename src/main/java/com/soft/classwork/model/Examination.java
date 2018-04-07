package com.soft.classwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Examination {

  @Id
  @GeneratedValue
  private Integer examiationid;

  private String examinationname;
  private Integer testid;
  private String starttime;
  private String endtime;
  private Integer roleid;



  public Integer getExamiationid() {
    return examiationid;
  }

  public void setExamiationid(Integer examiationid) {
    this.examiationid = examiationid;
  }


  public Integer getTestid() {
    return testid;
  }

  public void setTestid(Integer testid) {
    this.testid = testid;
  }


  public String getStarttime() {
    return starttime;
  }

  public void setStarttime(String starttime) {
    this.starttime = starttime;
  }


  public String getEndtime() {
    return endtime;
  }

  public void setEndtime(String endtime) {
    this.endtime = endtime;
  }


  public Integer getRoleid() {
    return roleid;
  }

  public void setRoleid(Integer roleid) {
    this.roleid = roleid;
  }


  public String getExaminationname() {
    return examinationname;
  }

  public void setExaminationname(String examinationname) {
    this.examinationname = examinationname;
  }
}

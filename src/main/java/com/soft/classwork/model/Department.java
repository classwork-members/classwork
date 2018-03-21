package com.soft.classwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Department {

  @Id
  @GeneratedValue
  private String deptid;

  private String deptname;

  private String deptdesc;

  public Department() {
  }

  public String getDeptid() {
    return deptid;
  }

  public void setDeptid(String deptid) {
    this.deptid = deptid;
  }


  public String getDeptname() {
    return deptname;
  }

  public void setDeptname(String deptname) {
    this.deptname = deptname;
  }


  public String getDeptdesc() {
    return deptdesc;
  }

  public void setDeptdesc(String deptdesc) {
    this.deptdesc = deptdesc;
  }

}

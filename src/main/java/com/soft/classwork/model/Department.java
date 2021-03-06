package com.soft.classwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Department {

  @Id
  @GeneratedValue
  private Integer deptid;

  private String deptname;

  private String deptdesc;

  private String deptprincipal;

  private String[] principalArr;

  public String[] getPrincipalArr() {
    return principalArr;
  }

  public void setPrincipalArr(String[] principalArr) {
    this.principalArr = principalArr;
  }

  public String getDeptprincipal() {
    return deptprincipal;
  }

  public void setDeptprincipal(String deptprincipal) {
    this.deptprincipal = deptprincipal;
  }

  public Department() {
  }

  public Integer getDeptid() {
    return deptid;
  }

  public void setDeptid(Integer deptid) {
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

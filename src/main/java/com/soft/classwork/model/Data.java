package com.soft.classwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Data {

  @Id
  @GeneratedValue
  private Integer dataid;
  private String datatype;
  private String content;
  private String dataname;

  public Data(String datatype,String content,String dataname) {
    this.datatype = datatype;
    this.content = content;
    this.dataname = dataname;
  }

  public Integer getDataid() {
    return dataid;
  }

  public void setDataid(Integer dataid) {
    this.dataid = dataid;
  }


  public String getDatatype() {
    return datatype;
  }

  public void setDatatype(String datatype) {
    this.datatype = datatype;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getDataname() {
    return dataname;
  }

  public void setDataname(String dataname) {
    this.dataname = dataname;
  }
}

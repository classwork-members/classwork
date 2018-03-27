package com.soft.classwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Data {

  @Id
  @GeneratedValue
  private Integer dataid;
  private long datatype;
  private String content;


  public Integer getDataid() {
    return dataid;
  }

  public void setDataid(Integer dataid) {
    this.dataid = dataid;
  }


  public long getDatatype() {
    return datatype;
  }

  public void setDatatype(long datatype) {
    this.datatype = datatype;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}

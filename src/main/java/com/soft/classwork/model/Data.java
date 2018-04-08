package com.soft.classwork.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})

public class Data {

  @Id
  @GeneratedValue
  private Integer dataid;
  private String datatype;
  private String content;
  private String dataname;

  public Data() {
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

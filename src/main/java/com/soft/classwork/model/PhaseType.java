package com.soft.classwork.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PhaseType {

  @Id
  @GeneratedValue

  private Integer phasetypeid;
  private String phasetypename;



  public Integer getPhasetypeid() {
    return phasetypeid;
  }

  public void setPhasetypeid(Integer phasetypeid) {
    this.phasetypeid = phasetypeid;
  }


  public String getPhasetypename() {
    return phasetypename;
  }

  public void setPhasetypename(String phasetypename) {
    this.phasetypename = phasetypename;
  }

}

package com.soft.classwork.model;

import javax.persistence.Entity;

@Entity
public class TestExam {

  private Integer testid;
  private Integer examid;
  private Integer score;


  public Integer getTestid() {
    return testid;
  }

  public void setTestid(Integer testid) {
    this.testid = testid;
  }


  public Integer getExamid() {
    return examid;
  }

  public void setExamid(Integer examid) {
    this.examid = examid;
  }


  public Integer getScore() {
    return score;
  }

  public void setScore(Integer score) {
    this.score = score;
  }

}

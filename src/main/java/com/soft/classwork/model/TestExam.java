package com.soft.classwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TestExam {

  @Id
  @GeneratedValue
  private Integer testexamid;

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


  public Integer getTestexamid() {
    return testexamid;
  }

  public void setTestexamid(Integer testexamid) {
    this.testexamid = testexamid;
  }

    @Override
    public String toString() {
        return "TestExam{" +
                "testexamid=" + testexamid +
                ", testid=" + testid +
                ", examid=" + examid +
                ", score=" + score +
                '}';
    }
}

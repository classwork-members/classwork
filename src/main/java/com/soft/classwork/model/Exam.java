package com.soft.classwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Yuukiiii
 * on 2018/3/22 08:34
 */

@Entity
public class Exam {

    @Id
    @GeneratedValue
    private Integer examid;
    private String question;
    private String alternativeA;
    private String alternativeB;
    private String alternativeC;

    private Character correctAnswer;

    public Exam() {
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAlternativeA() {
        return alternativeA;
    }

    public void setAlternativeA(String alternativeA) {
        this.alternativeA = alternativeA;
    }

    public String getAlternativeB() {
        return alternativeB;
    }

    public void setAlternativeB(String alternativeB) {
        this.alternativeB = alternativeB;
    }

    public String getAlternativeC() {
        return alternativeC;
    }

    public void setAlternativeC(String alternativeC) {
        this.alternativeC = alternativeC;
    }

    public Character getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Character correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}

package com.soft.classwork.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Yuukiiii
 * on 2018/3/22 08:34
 */

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Exam{

    @Id
    @GeneratedValue
    private Integer examid;

    private String alternativea;
    private String alternativeb;
    private String alternativec;
    private String alternatived;
    private String correctAnswer;
    private String question;
    private Integer illnessid;


    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }


    public String getAlternativea() {
        return alternativea;
    }

    public void setAlternativea(String alternativea) {
        this.alternativea = alternativea;
    }


    public String getAlternativeb() {
        return alternativeb;
    }

    public void setAlternativeb(String alternativeb) {
        this.alternativeb = alternativeb;
    }


    public String getAlternativec() {
        return alternativec;
    }

    public void setAlternativec(String alternativec) {
        this.alternativec = alternativec;
    }


    public String getAlternatived() {
        return alternatived;
    }

    public void setAlternatived(String alternatived) {
        this.alternatived = alternatived;
    }


    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public Integer getIllnessid() {
        return illnessid;
    }

    public void setIllnessid(Integer illnessid) {
        this.illnessid = illnessid;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examid=" + examid +
                ", alternativea='" + alternativea + '\'' +
                ", alternativeb='" + alternativeb + '\'' +
                ", alternativec='" + alternativec + '\'' +
                ", alternatived='" + alternatived + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", question='" + question + '\'' +
                ", illnessid=" + illnessid +
                '}';
    }
}

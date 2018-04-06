package com.soft.classwork.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yuukiiii
 * on 2018/4/6 13:37
 */


public class BigTest {

    private Test test;
    private Map<Exam,Integer> examIntegerMap;

    public BigTest(Test test, Map<Exam, Integer> examIntegerMap) {
        this.test = test;
        this.examIntegerMap = examIntegerMap;
    }

    public BigTest() {
        this.test = new Test();
        this.examIntegerMap = new LinkedHashMap<>();
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Map<Exam, Integer> getExamIntegerMap() {
        return examIntegerMap;
    }

    public void setExamIntegerMap(Map<Exam, Integer> examIntegerMap) {
        this.examIntegerMap = examIntegerMap;
    }

    public void addExamInteger(Exam exam,Integer score){
        examIntegerMap.put(exam,score);
    }

    @Override
    public String toString() {
        return "BigTest{" +
                "test=" + test +
                '}';
    }
}

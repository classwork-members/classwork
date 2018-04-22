package com.soft.classwork.model;

import java.util.List;

/**
 * Created by Yuukiiii
 * on 2018/4/22 15:25
 */


public class IllnessCases {

    private List<Cases> casesList;
    private String illnessdesc;

    public List<Cases> getCasesList() {
        return casesList;
    }

    public void setCasesList(List<Cases> casesList) {
        this.casesList = casesList;
    }

    public String getIllnessdesc() {
        return illnessdesc;
    }

    public void setIllnessdesc(String illnessdesc) {
        this.illnessdesc = illnessdesc;
    }
}

package com.soft.classwork.service;

import com.soft.classwork.model.Cases;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Yuukiiii
 * on 2018/4/10 01:46
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class CaseServiceTest {

    @Autowired
    private CaseService caseService;
//    @Test
//    public void findCasesByIllnessid() {
//        ///////
//        List<Cases> casesList = caseService.findCasesByIllnessid(3);
//
//        ///////
//        Assert.assertNotNull(casesList);
//    }

    @Test
    public void getAllCases() {
        ///////
        List<Cases> casesList = caseService.getAllCases(3);
        Assert.assertNotNull(casesList);
    }


    @Test
    public void showCasesInfo() {
        Assert.assertNotNull(caseService.showCasesInfo(125));
    }

    @Test
    public void searchCasesByCasename() {
        Assert.assertNotNull(caseService.searchCasesByCasename("老"));
    }
}

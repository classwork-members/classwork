package com.soft.classwork.service;

import com.soft.classwork.model.Examination;
import com.soft.classwork.repository.ExamRepository;
import com.soft.classwork.repository.ExaminaRepostitory;
import com.soft.classwork.repository.TestExamRepository;
import com.soft.classwork.repository.TestRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Yuukiiii
 * on 2018/4/10 02:04
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestServiceTest {

    @Autowired
    private TestService testService ;

    @Test
    public void getAllTest() {
        Assert.assertNotNull(testService.getAllTest());
    }

    @Test
    public void getAllTest2() {
        Assert.assertNotNull(testService.getAllTest2());
    }


    @Test
    public void getAllExamByTestid() {
        Assert.assertNotNull(testService.getAllExamByTestid(1));
    }

    @Test
    public void searchTest() {
        Assert.assertNotNull(testService.searchTest("第"));
    }

    @Test
    public void addExamination() {
        Assert.assertNotNull(testService.addExamination(new Examination()));
    }

    @Test
    public void searchExam() {
        Assert.assertNotNull(testService.searchExam("狗"));
    }
}

package com.soft.classwork.service;

import com.soft.classwork.model.Exam;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Yuukiiii
 * on 2018/4/10 01:55
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExamServiceTest {

    @Autowired
    private ExamService examService;

    @Test
    public void addExam() {
        Assert.assertNotNull(examService.addExam(new Exam()));
    }

    @Test
    public void findOneExam() {
        Assert.assertNotNull(examService.findOneExam(1));
    }

    @Test
    public void findAllExam() {
        Assert.assertNotNull(examService.findAllExam());
    }

    @Test
    public void findExamByIllnessid() {
        Assert.assertNotNull(examService.findExamByIllnessid(0));
    }
}

package com.soft.classwork;


import com.soft.classwork.model.Exam;
import com.soft.classwork.service.DeptService;
import com.soft.classwork.service.ExamService;
import com.soft.classwork.service.TestService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Yuukiiii
 * on 2018/4/10 00:05
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    private ExamService examService;


    @Test
    public void findOneExamTest(){
        Exam exam = examService.findOneExam(1);
        Assert.assertEquals("以下哪种不属于动物？",exam.getQuestion());
    }

}

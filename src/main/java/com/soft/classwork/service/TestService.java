package com.soft.classwork.service;

import com.soft.classwork.model.BigTest;
import com.soft.classwork.model.Exam;
import com.soft.classwork.model.Test;

import java.util.ArrayList;
import java.util.List;

import com.soft.classwork.model.TestExam;
import com.soft.classwork.repository.ExamRepository;
import com.soft.classwork.repository.TestExamRepository;
import com.soft.classwork.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Yuukiiii
 * on 2018/4/5 15:53
 */

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;

    @Autowired
    ExamRepository examRepository;

    @Autowired
    TestExamRepository testExamRepository;

    public List<BigTest> getAllTest(){
        List<BigTest> bigTests = new ArrayList<>();
        List<Test> tests = testRepository.findAll();
        System.out.println(tests.toString());
        for(Test t : tests) {
            BigTest bigTest = new BigTest();
            bigTest.setTest(t);

            Integer testid = t.getTestid();

            List<TestExam> testExamList = testExamRepository.findAllByTestid(testid);
            System.out.println(testExamList.toString());

            for(TestExam testExam : testExamList){
                Exam exam = examRepository.getOne(testExam.getExamid());
                System.out.println(exam.toString());
                bigTest.addExamInteger(exam,testExam.getScore());
                System.out.println(bigTest.toString());
            }
            bigTests.add(bigTest);
        }
        return bigTests;
    }
}

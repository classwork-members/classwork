package com.soft.classwork.service;

import com.soft.classwork.model.BigTest;
import com.soft.classwork.model.Exam;
import com.soft.classwork.model.Test;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Arrays;
=======
>>>>>>> 40
import java.util.List;
import java.util.Random;

import com.soft.classwork.model.TestExam;
import com.soft.classwork.repository.ExamRepository;
import com.soft.classwork.repository.TestExamRepository;
import com.soft.classwork.repository.TestRepository;
import com.soft.classwork.utils.NumberUtil;
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
<<<<<<< HEAD

    public List<Test> getAllTest2(){
        return testRepository.findAll();
    }

    public Test addtest1(String testname,Integer testime){
        Test test = new Test();
        test.setIllnessid(null);
        test.setTesttime(testime);
        test.setTotalscore(null);
        test.setTotalscore(null);
        test.setTestname(testname);
        test.setExamcount(null);
        return testRepository.save(test);
    }

    public void deletetest(Integer testid){
        testRepository.deleteById(testid);
        testExamRepository.deleteAllBytestid(testid);
    }

    public boolean randomtest(Integer testid,Integer illnessid,Integer score,Integer examcount){
        List<Exam> examList = examRepository.findAllByIllnessid(illnessid);
        Integer count = examList.size();
        System.out.println(count);
        Exam[] exams = new Exam[count];
        Integer[] examids = new Integer[count];
        Exam[] s = examList.toArray(exams);
        for (int i = 0; i <count ; i++) {
            examids[i] = exams[i].getExamid();
        }
        System.out.println(Arrays.toString(examids));
        int[] array = NumberUtil.getRandomIntegerArray(count,examcount);
        System.out.println(Arrays.toString(array));
        for (int i = 0; i <array.length ; i++) {
            TestExam testExam = new TestExam();
            testExam.setExamid(examids[array[i]]);
            testExam.setScore(score);
            testExam.setTestid(testid);
            TestExam testExam1 = testExamRepository.save(testExam);
//            if(testExam1==null);
//                return false;
        }
        return true;
    }


=======
>>>>>>> 40
}

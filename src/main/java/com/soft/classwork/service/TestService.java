package com.soft.classwork.service;

import com.soft.classwork.model.*;

import java.util.*;

import com.soft.classwork.repository.ExamRepository;
import com.soft.classwork.repository.ExaminaRepostitory;
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

    @Autowired
    ExaminaRepostitory examinaRepostitory;

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

    public List<Test> getAllTest2(){
        return testRepository.findAll();
    }

    public Test addtest1(String testname,Integer testime){
        Test test = new Test();
        test.setIllnessid(null);
        test.setTesttime(testime);
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
        Test test = testRepository.getOne(testid);
        test.setExamcount(examcount);
        test.setTotalscore(examcount*score);
        test.setIllnessid(illnessid);
        testRepository.save(test);
        return true;
    }

    public TestExam addOneExam(Integer testid,Integer examid,Integer score){
        TestExam testExam = new TestExam();
        testExam.setTestid(testid);
        testExam.setExamid(examid);
        testExam.setScore(score);
        return testExamRepository.save(testExam);

    }

    public Test updateTest(Integer testid,
                           String testname,
                           Integer testtime,
                           Integer score,
                           Integer examcount,
                           Integer illnessid
                           ){
        Test test = new Test();
        test.setTotalscore(score*examcount);
        test.setExamcount(examcount);
        test.setTestname(testname);
        test.setTestid(testid);
        test.setTesttime(testtime);
        test.setIllnessid(illnessid);
        return testRepository.save(test);

    }

    public List<Exam> getAllExamByTestid(Integer testid){
        System.out.println("test");
        List<TestExam> testExamList = testExamRepository.findAllByTestid(testid);
        List<Exam> examList = new LinkedList<>();
        System.out.println(testExamList.toString());
        for (TestExam t : testExamList){
            Integer in = t.getExamid();
            Exam exam = examRepository.getOne(in);
            System.out.println(exam.toString());
            examList.add(exam);
        }
        System.out.println(examList.toString());
        return examList;
    }

    public List<Test> searchTest(String testname){
        return testRepository.findAllByTestnameContaining(testname);
    }

    public Examination addExamination(Examination examination){
        return examinaRepostitory.save(examination);
    }

    public void deleteExamination(Integer examinationid){
        examinaRepostitory.deleteById(examinationid);
    }

    public List<Exam> searchExam(String question){
        return examRepository.findAllByQuestionContaining(question);
    }
}

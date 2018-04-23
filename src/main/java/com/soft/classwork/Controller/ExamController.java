package com.soft.classwork.Controller;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.model.*;
import com.soft.classwork.repository.ExaminaRepostitory;
import com.soft.classwork.service.ExamService;
import com.soft.classwork.service.TestService;
import com.soft.classwork.service.UserTestService;
import com.soft.classwork.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yuukiiii
 * on 2018/4/4 16:43
 */

@RestController
public class ExamController {

    @Autowired
    ExamService examService;

    @Autowired
    TestService testService;

    @Autowired
    UserTestService userTestService;

    //35
    @GetMapping(value = "/examManage/allExam")
    public Result getAllExam() {
        List<Exam> examList = examService.findAllExam();
        if (examList == null) {
            return ResultUtil.Error(ResultEnum.GETDARA_FAIL);
        }
        return ResultUtil.success(examList);
    }

    //36
    @GetMapping(value = "/examManage/examByIllnessid")
    public Result getExamByIllnessid(@RequestParam("illnessid") Integer illnessid) {
        List<Exam> examList = examService.findExamByIllnessid(illnessid);
        if (examList == null)
            return ResultUtil.Error(ResultEnum.GETDARA_FAIL);
        return ResultUtil.success(examList);
    }

    //37
    @PostMapping(value = "/examManage/addExam")
    public Result addExam(Exam exam) {
        if (examService.addExam(exam)==null)
            return ResultUtil.Error(ResultEnum.USER_NULL);
        return ResultUtil.success(ResultEnum.SUCCESS);
    }

    //38
    @PostMapping(value = "/examManage/deleteExam")
    public Result deleteExam(@RequestParam("examid") Integer examid){
        examService.deleteExam(examid);
        return ResultUtil.success(ResultEnum.SUCCESS);
    }

    //39
    @PostMapping(value = "/examManage/updateExam")
    public Result updateExam(@RequestParam("examid") Integer examid,
                             @RequestParam("question") String question,
                             @RequestParam("alternativeA") String alternativeA,
                             @RequestParam("alternativeB") String alternativeB,
                             @RequestParam("alternativeC") String alternativeC,
                             @RequestParam("alternativeD") String alternativeD,
                             @RequestParam("correctAnswer") String correctAnswer,
                             @RequestParam("illnessid") Integer illnessid) {
        Exam exam = examService.updateExam(examid,question,alternativeA,alternativeB,alternativeC,
                alternativeD,correctAnswer,illnessid);
        if (exam==null)
            return ResultUtil.Error(ResultEnum.UPDATE_FAIL);
        return ResultUtil.success(exam);
    }

    //40
    @GetMapping(value = "/examManage/alltest2")
    public Object getAllTest(){
        List<BigTest> bigTests =  testService.getAllTest();
        if (bigTests==null)
            return ResultUtil.Error(ResultEnum.GETDARA_FAIL);
        //System.out.println(bigTests.toString());
        return bigTests;
    }

    //40
    @GetMapping(value = "/examManage/alltest")
    public Result getAlltest(){
        List<Test> testList = testService.getAllTest2();
        if (testList==null)
            return ResultUtil.Error(ResultEnum.GETDARA_FAIL);
        return ResultUtil.success(testList);
    }

    //41
    @PostMapping(value = "/examManage/addtest1")
    public Result addtest1(@RequestParam("testname") String testname,
                           @RequestParam("testtime") Integer testtime) {
        Test test = testService.addtest1(testname, testtime);
        if (test==null)
            return ResultUtil.Error(ResultEnum.INSERT_FAIL);
        return ResultUtil.success(test);
    }

    //42
    @PostMapping(value = "/examManage/randomtest")
    public Result ramdomtest(@RequestParam("testid") Integer testid,
                             @RequestParam("illnessid") Integer illnessid,
                             @RequestParam("score") Integer score,
                             @RequestParam("examcount") Integer examcount){
        Boolean b = testService.randomtest(testid,illnessid,score,examcount);
        if (!b)
            return ResultUtil.Error(ResultEnum.UPDATE_FAIL);
        return ResultUtil.success("random success");
    }

    //43
    @PostMapping(value = "/examManage/addOneExam")
    public Result addOneExam(@RequestParam("testid") Integer testid,
                             @RequestParam("examid") Integer examid,
                             @RequestParam("score") Integer score){
        TestExam testExam = testService.addOneExam(testid,examid,score);
        if (testExam==null)
            return ResultUtil.Error(ResultEnum.INSERT_FAIL);
        return ResultUtil.success(testExam);

    }
    //44
    @PostMapping(value = "/examManage/deletetest")
    public Result deletetest(@RequestParam("testid") Integer testid){
        testService.deletetest(testid);
        return ResultUtil.success("delete success!");
    }

    //45
    @PostMapping(value = "/examManage/updateTest")
    public Result updateTest(@RequestParam("testid") Integer testid,
                             @RequestParam("testname") String testname,
                             @RequestParam("testtime") Integer testtime,
                             @RequestParam("score") Integer score,
                             @RequestParam("examcount") Integer examcount,
                             @RequestParam("illnessid") Integer illnessid){
        Test test = testService.updateTest(testid,testname,testtime,score,examcount,illnessid);
        if (test==null)
            return ResultUtil.Error(ResultEnum.UPDATE_FAIL);
        return ResultUtil.success(test);
    }

    //46
    @GetMapping(value = "/examManage/getAllExamByTestid")
    public Result getAllExamByTestid(@RequestParam("testid") Integer testid){
        List<Exam> examList = testService.getAllExamByTestid(testid);
        if (examList==null)
            return ResultUtil.Error(ResultEnum.GETDARA_FAIL);
        return ResultUtil.success(examList);
    }

    //47
    @GetMapping(value = "/examManage/searchTestByName")
    public Result searchTestByName(@RequestParam("testname") String testname){
        System.out.println(testname);
        List<Test> testList = testService.searchTest(testname);
        if(testList==null)
            return ResultUtil.Error(ResultEnum.GETDARA_FAIL);
        else if (testList.size()==0)
            return ResultUtil.success("nothing found");
        else
            return ResultUtil.success(testList);

    }

    //48
    @PostMapping(value = "/examManage/addExamination")
    public Result addExamination(Examination examination){
        Examination examination1 = testService.addExamination(examination);
        if (examination1==null)
            return ResultUtil.Error(ResultEnum.INSERT_FAIL);
        return ResultUtil.success(examination1);
    }

    //49
    @PostMapping(value = "/examManage/deleteExamination")
    public Result deleteExamination(@RequestParam("examinationid") Integer examinationid){
        testService.deleteExamination(examinationid);
        return ResultUtil.success("delete success");
    }

    //50
    @PostMapping(value = "/examManage/updateExamination")
    public Result updateExamination(Examination examination){
        Examination examination1 = testService.addExamination(examination);
        if (examination1==null)
            return ResultUtil.Error(ResultEnum.UPDATE_FAIL);
        return ResultUtil.success(examination1);

    }

    //52
    @GetMapping(value = "/examManage/searchExamByName")
    public Result searchExamByName(@RequestParam("question") String question){
        List<Exam> examList = testService.searchExam(question);
        if(examList==null)
            return ResultUtil.Error(ResultEnum.GETDARA_FAIL);
        else if (examList.size()==0)
            return ResultUtil.success("nothing found");
        else
            return ResultUtil.success(examList);

    }

    //53
    @GetMapping(value = "/examManage/getAllExamination")
    public Result getAllExamination(){
        List<Examination> examinationList = testService.getAllExamination();
        if (examinationList==null)
            return ResultUtil.Error(ResultEnum.GETDARA_FAIL);
        else if (examinationList.size()==0)
            return ResultUtil.success("nothing found");
        else
            return ResultUtil.success(examinationList);
    }


    @PostMapping(value = "/examManage/searchByExaminaName")
    public Result searchByExaminaName(@RequestParam(value = "ExaminaName") String name){
        List<Examination> examinationList = testService.searchByExaminaName(name);
        if (examinationList==null){
            return ResultUtil.Error(ResultEnum.GETDARA_FAIL);
        }
        return ResultUtil.success(examinationList);
    }

    @PostMapping(value = "/examManage/addUserTest")
    public Result addUserTest(UserTest userTest){
        UserTest userTest1 = userTestService.addUserTest(userTest);
        if (userTest1==null){
            return ResultUtil.Error(ResultEnum.INSERT_FAIL);
        }
        return ResultUtil.success(userTest1);
    }

    @PostMapping(value = "/examManage/deleteUserTest")
    public Result deleteUserTest(@RequestParam(value = "userid") Integer userid,
                                 @RequestParam(value = "testid") Integer testid){
        userTestService.deleteUserTestByUseridAndTestid(userid,testid);
        return ResultUtil.success("delete success!");
    }

    @PostMapping(value = "/examManage/deleteExaminTest")
    public Result deleteExaminTest(@RequestParam(value = "testid") Integer testid,
                                   @RequestParam(value = "examid") Integer examid){
        testService.deleteExaminTest(testid,examid);
        return ResultUtil.success("delete success!");
    }

}
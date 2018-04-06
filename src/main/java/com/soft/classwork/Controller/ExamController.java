package com.soft.classwork.Controller;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.model.BigTest;
import com.soft.classwork.model.Exam;
import com.soft.classwork.model.Result;
import com.soft.classwork.service.ExamService;
import com.soft.classwork.service.TestService;
import com.soft.classwork.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;

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
    @GetMapping(value = "/examManage/alltest")
    public Object getAllTest(){
        List<BigTest> bigTests =  testService.getAllTest();
        if (bigTests==null)
            return ResultUtil.Error(ResultEnum.GETDARA_FAIL);
        //System.out.println(bigTests.toString());
        return bigTests;
    }
}
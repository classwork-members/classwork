package com.soft.classwork.Controller;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.model.Exam;
import com.soft.classwork.model.Result;
import com.soft.classwork.service.ExamService;
import com.soft.classwork.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @GetMapping(value = "/examManage/allExam")
    public Result getAllExam() {
        List<Exam> examList = examService.findAllExam();
        if (examList == null) {
            return ResultUtil.Error(ResultEnum.GETDARA_FAIL);
        }
        return ResultUtil.success(examList);
    }

    @GetMapping(value = "/examManage/examByIllnessid")
    public Result getExamByIllnessid(@RequestParam("illnessid") Integer illnessid) {
        List<Exam> examList = examService.findExamByIllnessid(illnessid);
        if (examList == null) {
            return ResultUtil.Error(ResultEnum.GETDARA_FAIL);
        }
        return ResultUtil.success(examList);
    }

    @PostMapping(value = "/examManage/addExam")
    public Result addExam(Exam exam) {
        return ResultUtil.success(examService.addExam(exam));
    }
}
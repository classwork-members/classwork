package com.soft.classwork.Controller;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.model.Illness;
import com.soft.classwork.model.Result;
import com.soft.classwork.service.IllnessService;
import com.soft.classwork.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Yuukiiii
 * on 2018/4/21 14:01
 */

@RestController
@RequestMapping(value = "/illness")
public class IllnessController {

    @Autowired
    IllnessService illnessService;

    @RequestMapping(value = "getOneIllness")
    public Result getOneIllness(@RequestParam(value = "illnessid") Integer illnessid){
        Illness illness = illnessService.getOneIllness(illnessid);
        if (illness==null){
            return ResultUtil.Error(ResultEnum.GETDARA_FAIL);
        }
        return ResultUtil.success(illness);
    }
}

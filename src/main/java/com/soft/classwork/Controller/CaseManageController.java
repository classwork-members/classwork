package com.soft.classwork.Controller;

import com.soft.classwork.enums.IllnessEnum;
import com.soft.classwork.model.Result;
import com.soft.classwork.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Yuukiiii
 * on 2018/4/2 14:02
 */

@Controller
@RequestMapping(value = "/caseManage")
public class CaseManageController {
    @Autowired
    CaseService caseService;

//    @RequestMapping(value = "/addCase")
//    public Result addCase(@RequestParam("blm") String blm,
//                          @RequestParam("bllb") String bllb,
//                          @RequestParam("rq") String rq,
//                          @RequestParam("jz") String jz,
//                          @RequestParam("jc") String jc,
//                          @RequestParam("zd") String zd,
//                          @RequestParam("zl") String zl,
//                          @RequestParam("num") String num){
//
//    }
}

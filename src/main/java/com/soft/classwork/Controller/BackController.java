package com.soft.classwork.Controller;

import com.soft.classwork.service.CaseService;
import com.soft.classwork.model.Result;
import com.soft.classwork.utils.ResultUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Yuukiiii
 * on 2018/3/21 16:23
 */

@RestController
public class BackController {

    @Autowired
    CaseService caseService;

    @PostMapping(value = "/hello")
    public Object hello(@RequestParam("username") String username,
                        @RequestParam("password") String password ){
        Result result = new Result();
        if(username.equals("123")&&password.equals("123")){
            return ResultUtil.success("1");
        }else
            return null;
    }

    @PostMapping(value = "/manageCase2/{bingzhong}")
    public Object test2(@PathVariable("bingzhong") String bingzhong){
        return caseService.findCasesByIllnessid(8);
    }
}

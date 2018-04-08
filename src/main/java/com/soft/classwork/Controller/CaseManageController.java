package com.soft.classwork.Controller;

import com.soft.classwork.enums.IllnessEnum;
import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.model.Result;
import com.soft.classwork.service.CaseService;
import com.soft.classwork.utils.FileUtil;
import com.soft.classwork.utils.FtpFileUtil;
import com.soft.classwork.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Yuukiiii
 * on 2018/4/2 14:02
 */

@RestController
@RequestMapping(value = "/caseManage")
public class CaseManageController {
    @Autowired
    CaseService caseService;

    @PostMapping(value = "/addCase")
    public Result addCase(@RequestParam("blm") String blm,
                          @RequestParam("illnessid") Integer illnessid,
                          @RequestParam("rq") String rq,
                          @RequestParam("jz") MultipartFile jz,
                          @RequestParam("jztext") String jztext
//                          ,@RequestParam("jc") MultipartFile jc,
//                          @RequestParam("jctext") String jctext,
//                          @RequestParam("zd") MultipartFile zd,
//                          @RequestParam("zdtext") String zdtext,
//                          @RequestParam("zl") MultipartFile zl,
//                          @RequestParam("zltext") String zltext
    )
                            throws IOException{
        return caseService.addCase(blm, illnessid, rq, jz
               ,jztext
//                 jc, jctext, zd, zdtext, zl, zltext
        );
    }

    @GetMapping(value = "getAllCases")
    public Result getAllCase(Integer illnessid){
        return ResultUtil.success(caseService.getAllCases());

    }
}

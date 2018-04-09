package com.soft.classwork.Controller;

import com.soft.classwork.enums.IllnessEnum;
import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.model.Cases;
import com.soft.classwork.model.Data;
import com.soft.classwork.model.Result;
import com.soft.classwork.service.CaseService;
import com.soft.classwork.utils.FileUtil;
import com.soft.classwork.utils.FtpFileUtil;
import com.soft.classwork.utils.ResultUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
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

    //add and update
    @PostMapping(value = "/addCase")
    public Result addCaseWords(@RequestParam("blm") String blm,
                          @RequestParam("illnessid") Integer illnessid,
                          @RequestParam("rq") String rq,
                          //@RequestParam("jz") MultipartFile jz,
                          @RequestParam("jztext") String jztext,
//                          ,@RequestParam("jc") MultipartFile jc,
                          @RequestParam("jctext") String jctext,
//                          @RequestParam("zd") MultipartFile zd,
                          @RequestParam("zdtext") String zdtext,
//                          @RequestParam("zl") MultipartFile zl,
                          @RequestParam("zltext") String zltext
    )
                            throws IOException{
        return caseService.addCaseWords(blm, illnessid, rq,jztext, jctext, zdtext,  zltext);
    }

    //5
    @GetMapping(value = "/getAllCases")
    public Result getAllCase(Integer illnessid){
        return ResultUtil.success(caseService.getAllCases(illnessid));

    }
//    //6
//    @GetMapping(value = "getCaseInfo")
//    public Result getCaseInfo(Integer illnessid){
//
//    }

    @PostMapping(value = "/deleteAllCaseWords")
    public Result deleteAllCaseData(Integer casesid){
        caseService.deleteAllCaseData(casesid);
        return ResultUtil.success("delete all case words success");
    }

    @PostMapping(value = "/deleteOneCaseWords")
    public Result deleteOneCaseData(Integer casesid,String casephasename){
        caseService.deleteOneCaseData(casesid,casephasename);
        return ResultUtil.success("delete all one case words success");
    }

    @PostMapping(value = "/deleteOneData")
    public Result deleteOneData(Integer dataid){
        caseService.deleteOneCaseData(dataid);
        return ResultUtil.success("delete one case words success");
    }

    @PostMapping(value = "/updateCasesWords")
    public Result updateCasesWords(@RequestParam("blm") String blm,
                                   @RequestParam("casesid") Integer casesid,
                                   @RequestParam("illnessid") Integer illnessid,
                                   @RequestParam("rq") String rq,
                                   @RequestParam("dataid1") Integer dataid1, @RequestParam("jztext") String words1,
                                   @RequestParam("dataid2") Integer dataid2, @RequestParam("jctext") String words2,
                                   @RequestParam("dataid3") Integer dataid3, @RequestParam("zdtext") String words3,
                                   @RequestParam("dataid4") Integer dataid4, @RequestParam("zltext") String words4){
        caseService.updateCasesWords(blm,casesid,illnessid,rq,dataid1,words1,dataid2,words2,dataid3,words3,dataid4,words4);
        return ResultUtil.success("update success");

    }

    @GetMapping(value = "/getOneCasesAllData")
    public Result getOneCasesAllData(@RequestParam("casesid") Integer casesid){
        List<Object> dataList = caseService.getOneCasesAllData(casesid);
        if (dataList==null)
            return ResultUtil.Error(ResultEnum.GETDARA_FAIL);
        return ResultUtil.success(dataList);
    }

    @PostMapping(value = "/addOneFileData")
    public Result addOneFileData(@RequestParam("file") MultipartFile file,
                                 @RequestParam("casesid") Integer casesid,
                                 @RequestParam("casephasename") String casephasename) throws IOException{
        System.out.println(casephasename);
        System.out.println(casesid);
        return caseService.addOneFileData(file,casesid,casephasename);
    }

    @GetMapping(value = "/showCasesInfo")
    public Result showCasesInfo(@RequestParam("casesid") Integer casesid){
        List<Data> dataList = caseService.showCasesInfo(casesid);
        if (dataList==null)
            return ResultUtil.Error(ResultEnum.GETDARA_FAIL);
        return ResultUtil.success(dataList);
    }

    @GetMapping(value = "/searchCasesByName")
    public Result searchCasesByName(@RequestParam("casename") String casename){
        List<Cases> casesList = caseService.searchCasesByCasename(casename);
        if(casesList==null)
            return ResultUtil.Error(ResultEnum.GETDARA_FAIL);
        else if (casesList.size()==0)
            return ResultUtil.success("nothing found");
        else
            return ResultUtil.success(casesList);
    }

    @PostMapping(value = "/searchCasesByNameAndIllnessid")
    public Result searchCasesByNameAndIllnessid(@RequestParam("casename") String casename,
                                                @RequestParam("illnessid") Integer illnessid){
        //Integer illnessid1 = Integer.parseInt(illnessid);
        System.out.println(1);
        List<Cases> casesList = caseService.searchCasesByCasenameAndIllnessid(casename,illnessid);
        if(casesList==null)
            return ResultUtil.Error(ResultEnum.GETDARA_FAIL);
        else if (casesList.size()==0)
            return ResultUtil.success("nothing found");
        else
            return ResultUtil.success(casesList);
    }

    @PostMapping(value = "/deleteCase")
    public Result deleteCase(@RequestParam("casesid") Integer casesid){
        caseService.deleteCase(casesid);
        return ResultUtil.success("delete case success");
    }
}

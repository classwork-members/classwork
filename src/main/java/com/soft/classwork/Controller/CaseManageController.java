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
    public Result addCaseWords(@RequestParam("blm") String blm,//病例名
                          @RequestParam("illnessid") Integer illnessid,//3
                          @RequestParam("rq") String rq,//日期
                          //@RequestParam("jz") MultipartFile jz,
                          @RequestParam(value = "jztext", required = false) String jztext,//接诊
//                          ,@RequestParam("jc") MultipartFile jc,
                          @RequestParam(value = "jctext", required = false) String jctext,//检查
//                          @RequestParam("zd") MultipartFile zd,
                          @RequestParam(value = "zdtext", required = false) String zdtext,//诊断
//                          @RequestParam("zl") MultipartFile zl,
                          @RequestParam(value = "zltext", required = false) String zltext//治疗
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
    public Result addOneFileData(@RequestParam("file1") MultipartFile file,
                                 @RequestParam("casesid") Integer casesid,//3
                                 @RequestParam("casephasename") String casephasename,
                                 @RequestParam(value = "file2",required = false) MultipartFile file2,
                                 @RequestParam(value = "file3",required = false) MultipartFile file3,
                                 @RequestParam(value = "file4",required = false) MultipartFile file4,
                                 @RequestParam(value = "file5",required = false) MultipartFile file5) throws IOException{
        boolean flag = false;
        if (!caseService.addOneFileData(file,casesid,casephasename))
            return ResultUtil.Error(ResultEnum.UPLOAD_FAIL);

        if (file2==null)
            return  ResultUtil.success("one data upload success!");
        else{
            if (!caseService.addOneFileData(file2,casesid,casephasename))
                return ResultUtil.Error(ResultEnum.UPLOAD_FAIL);
        }
        if (file3==null)
            return  ResultUtil.success("two datas upload success!");
        else{
            if (!caseService.addOneFileData(file3,casesid,casephasename))
                return ResultUtil.Error(ResultEnum.UPLOAD_FAIL);
        }
        if (file4==null)
            return  ResultUtil.success("three datas upload success!");
        else{
            if (!caseService.addOneFileData(file4,casesid,casephasename))
                return ResultUtil.Error(ResultEnum.UPLOAD_FAIL);
        }
        if (file5==null)
            return  ResultUtil.success("four datas upload success!");
        else{
            if (!caseService.addOneFileData(file5,casesid,casephasename))
                return ResultUtil.Error(ResultEnum.UPLOAD_FAIL);
        }
        return  ResultUtil.success("five datas upload success!");
    }
//    @PostMapping(value = "/addOneFileData")
//    public Result addOneFileData(@RequestParam("file1") MultipartFile[] files,
//                                 @RequestParam("casesid") Integer casesid,//3
//                                 @RequestParam("casephasename") String casephasename) throws IOException{
//        boolean flag = false;
//        for (int i =0;i<files.length)
//            caseService.addOneFileData()
//    }
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

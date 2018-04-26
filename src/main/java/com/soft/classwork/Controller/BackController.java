package com.soft.classwork.Controller;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.service.CaseService;
import com.soft.classwork.model.Result;
import com.soft.classwork.utils.FileUtil;
import com.soft.classwork.utils.FtpFileUtil;
import com.soft.classwork.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


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
                        @RequestParam("password") String password) {
        Result result = new Result();
        if (username.equals("123") && password.equals("123")) {
            return ResultUtil.success("1");
        } else
            return null;
    }

    @PostMapping(value = "/manageCase2/{bingzhong}")
    public Object test2(@PathVariable("bingzhong") int bingzhong) {
        return caseService.findCasesByIllnessid(bingzhong);
    }

    //    @RequestMapping(value = "/ftpuploadimg", method = RequestMethod.POST)
//    public Result uploadImg(@RequestParam("file") MultipartFile file,
//                     HttpServletRequest request) throws IOException {
//
//        String fileName = file.getOriginalFilename();
//        InputStream inputStream = file.getInputStream();
//        String filePath = null;
//
//
//        File dir = new File("upload/");
//        if (!dir.exists()) {
//            dir.mkdir();
//        }
//        String path = "upload/" + file.getOriginalFilename();
//        try {
//            FileUtil.uploadFile(file.getBytes(), "upload/",fileName);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResultUtil.Error(ResultEnum.UPLOAD_FAIL);
//        }
//        FtpFileUtil.uploadFile(fileName,new FileInputStream(path),fileName);
//
//        File deletefile = new File(path);
//        deletefile.delete();
//
//
//
//        return ResultUtil.success("upload success");  //该路径图片名称，前端框架可用ngnix指定的路径+filePath,即可访问到ngnix图片服务器中的图片
//
//
//
//    }
//
//    @PostMapping(value = "/addCase")
//    public String addCase()
    @PostMapping(value = "/addOneFileData2")
    public String addOneFileData(@RequestParam("file") MultipartFile file,
                                 @RequestParam("casesid") Integer casesid,
                                 @RequestParam("illnessid") Integer illnessid,
                                 @RequestParam("casephasename") String casephasename) throws IOException{
        caseService.addOneFileData(file,casesid,casephasename);
        return "manageCase.html?id="+illnessid.toString();
    }
    @PostMapping(value = "/test/upload")
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
}
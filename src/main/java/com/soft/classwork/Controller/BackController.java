package com.soft.classwork.Controller;

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

    @RequestMapping(value = "/ftpuploadimg", method = RequestMethod.POST)
    public @ResponseBody
    String uploadImg(@RequestParam("file") MultipartFile file,
                     HttpServletRequest request) throws IOException {

        String fileName = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        String filePath = null;

        try {
            File dir = new File("upload/");
            if (!dir.exists()) {
                dir.mkdir();
            }
            String path = "upload/" + file.getOriginalFilename();
            FileUtil.uploadFile(file.getBytes(), "upload/", fileName);
            FtpFileUtil.uploadFile(fileName,new FileInputStream(path));

            //File deletefile = new File(path);
            //deletefile.delete();

        } catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            return fileName;  //该路径图片名称，前端框架可用ngnix指定的路径+filePath,即可访问到ngnix图片服务器中的图片
        }


    }
//
//    @PostMapping(value = "/addCase")
//    public String addCase()
}
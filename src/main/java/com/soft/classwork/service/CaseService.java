package com.soft.classwork.service;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.model.Cases;
import com.soft.classwork.model.CasesPhase;
import com.soft.classwork.model.Data;
import com.soft.classwork.model.Result;
import com.soft.classwork.repository.CaseRepository;
import com.soft.classwork.repository.CasesPhaseRepository;
import com.soft.classwork.repository.DataRepository;
import com.soft.classwork.utils.FileUtil;
import com.soft.classwork.utils.FtpFileUtil;
import com.soft.classwork.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Yuukiiii
 * on 2018/3/27 15:21
 */

@Service
public class CaseService {
    @Autowired
    CaseRepository caseRepository;

    @Autowired
    DataRepository dataRepository;

    @Autowired
    CasesPhaseRepository casesPhaseRepository;

    public List<Cases> findCasesByIllnessid(Integer illnessId){
        return caseRepository.findCasesByIllnessid(illnessId);
    }

    public Result addCase(String blm,
                          Integer illnessid,
                          String rq,
                          MultipartFile jz
                          ,String jztext
//                          MultipartFile jc,
//                          String jctext,
//                          MultipartFile zd,
//                          String zdtext,
//                          MultipartFile zl,
//                          String zltext
    )throws IOException {
        String jzName = jz.getOriginalFilename();
//        String jcName = jc.getOriginalFilename();
//        String zdName = zd.getOriginalFilename();
//        String zlName = zl.getOriginalFilename();


        InputStream inputStreamjz = jz.getInputStream();
//        InputStream inputStreamjc = jc.getInputStream();
//        InputStream inputStreamzd = zd.getInputStream();
//        InputStream inputStreamzl = zl.getInputStream();


        String filePath = "/"+illnessid;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.format(date);
        Cases cases = caseRepository.save(new Cases(blm,illnessid,date.toString()));

        if (cases==null)
            return ResultUtil.Error(ResultEnum.ADD_CASE_FAIL);
        Integer casesid = cases.getCaseid();
        filePath=filePath+"/"+casesid;

        File dir = new File("upload/");
        if (!dir.exists()) {
            dir.mkdir();
        }
        if (!jzName.equals("")) {
            filePath=filePath+"/jz";
            String filetype = FileUtil.checkFileType(jzName);
            Data data = dataRepository.save(new Data(filetype,filePath,jzName));
            if (cases==null)
                return ResultUtil.Error(ResultEnum.ADD_DATA_FAIL);
            Integer dataid = data.getDataid();
////////////////////////////////////////////////////数据插入
            String path = "upload/" + jz.getOriginalFilename();
            try {
                FileUtil.uploadFile(jz.getBytes(), "upload/", jzName);
            } catch (Exception e) {
                e.printStackTrace();
                ResultUtil.Error(ResultEnum.UPLOAD_FAIL);
            }
            FtpFileUtil.uploadFile(jzName, new FileInputStream(path),illnessid.toString(),casesid.toString(),dataid.toString());

            File deletefile = new File(path);
            deletefile.delete();
////////////////////////////////////////////////////数据插入结束
            CasesPhase casesPhase = casesPhaseRepository.save(new CasesPhase(casesid,"jz",dataid));
            if (casesPhase==null)
                return ResultUtil.Error(ResultEnum.ADD_CASESPHASE_FAIL);

        }
        else if (!jztext.equals("")){
            String filetype = "文字";
            Data data = dataRepository.save(new Data(filetype,jztext,"概述"));
            if (cases==null)
                return ResultUtil.Error(ResultEnum.ADD_DATA_FAIL);
            Integer dataid = data.getDataid();
        }
        return ResultUtil.success("添加新病例及文件上传成功！");
    }

    public List<Cases> getAllCases(Integer illnessid){
        return caseRepository.findAll();

    }
}


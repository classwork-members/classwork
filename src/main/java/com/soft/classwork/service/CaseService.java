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
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
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

//    public Result addCase(String blm,
//                          Integer illnessid,
//                          String rq,
//                          MultipartFile jz
//                          ,String jztext
////                          MultipartFile jc,
////                          String jctext,
////                          MultipartFile zd,
////                          String zdtext,
////                          MultipartFile zl,
////                          String zltext
//    )throws IOException {
//        String jzName = jz.getOriginalFilename();
////        String jcName = jc.getOriginalFilename();
////        String zdName = zd.getOriginalFilename();
////        String zlName = zl.getOriginalFilename();
//
//
//        InputStream inputStreamjz = jz.getInputStream();
////        InputStream inputStreamjc = jc.getInputStream();
////        InputStream inputStreamzd = zd.getInputStream();
////        InputStream inputStreamzl = zl.getInputStream();
//
//
//        String filePath = "/illnessid"+illnessid;
//        Cases cases = caseRepository.save(new Cases(blm,illnessid,rq));
//
//        if (cases==null)
//            return ResultUtil.Error(ResultEnum.ADD_CASE_FAIL);
//        Integer casesid = cases.getCaseid();
//        filePath=filePath+"/casesid"+casesid;
//
//        File dir = new File("upload/");
//        if (!dir.exists()) {
//            dir.mkdir();
//        }
//        if (!jzName.equals("")) {
//            filePath=filePath+"/jz";
//            String filetype = FileUtil.checkFileType(jzName);
//            Data data = dataRepository.save(new Data(filetype,filePath,jzName));
//            if (cases==null)
//                return ResultUtil.Error(ResultEnum.ADD_DATA_FAIL);
//            Integer dataid = data.getDataid();
//////////////////////////////////////////////////////数据插入
//            String path = "upload/" + jz.getOriginalFilename();
//            try {
//                FileUtil.uploadFile(jz.getBytes(), "upload/", jzName);
//            } catch (Exception e) {
//                e.printStackTrace();
//                ResultUtil.Error(ResultEnum.UPLOAD_FAIL);
//            }
//            FtpFileUtil.uploadFile(jzName, new FileInputStream(path),"illnessid"+illnessid.toString(),"casesid"+casesid.toString(),"jz");
//
//            File deletefile = new File(path);
//            deletefile.delete();
//////////////////////////////////////////////////////数据插入结束
//            CasesPhase casesPhase = casesPhaseRepository.save(new CasesPhase(casesid,"jz",dataid));
//            if (casesPhase==null)
//                return ResultUtil.Error(ResultEnum.ADD_CASESPHASE_FAIL);
//
//        }
//        if (!jztext.equals("")){
//            String filetype = "文字";
//            Data data = dataRepository.save(new Data(filetype,jztext,"概述"));
//            if (cases==null)
//                return ResultUtil.Error(ResultEnum.ADD_DATA_FAIL);
//            Integer dataid = data.getDataid();
//            CasesPhase casesPhase = casesPhaseRepository.save(new CasesPhase(casesid,"jz",dataid));
//            if (casesPhase==null)
//                return ResultUtil.Error(ResultEnum.ADD_CASESPHASE_FAIL);
//        }
//        return ResultUtil.success("添加新病例及文件上传成功！");
//    }

    public List<Cases> getAllCases(Integer illnessid){
        return caseRepository.findCasesByIllnessid(illnessid);

    }

    public Result addCaseWords( String blm,
                           Integer illnessid,
                           String rq,
                           String jztext,
                           String jctext,
                           String zdtext,
                           String zltext){
        Cases cases = caseRepository.save(new Cases(blm,illnessid,rq));
        if (cases==null)
            return ResultUtil.Error(ResultEnum.ADD_CASE_FAIL);
        Integer casesid = cases.getCaseid();

        if (!jztext.equals("")){
            String filetype = "文字";
            Data data1 = new Data();
            data1.setDatatype("概述");
            data1.setDataname(filetype);
            data1.setContent(jztext);
            Data data = dataRepository.save(data1);
            if (data==null)
                return ResultUtil.Error(ResultEnum.ADD_DATA_FAIL);
            Integer dataid = data.getDataid();
            CasesPhase casesPhase = casesPhaseRepository.save(new CasesPhase(casesid,"jz",dataid));
            if (casesPhase==null)
                return ResultUtil.Error(ResultEnum.ADD_CASESPHASE_FAIL);
        }
        if (!jctext.equals("")){
            String filetype = "文字";
            Data data1 = new Data();
            data1.setDatatype("概述");
            data1.setDataname(filetype);
            data1.setContent(jctext);
            Data data = dataRepository.save(data1);
            if (data==null)
                return ResultUtil.Error(ResultEnum.ADD_DATA_FAIL);
            Integer dataid = data.getDataid();
            CasesPhase casesPhase = casesPhaseRepository.save(new CasesPhase(casesid,"jc",dataid));
            if (casesPhase==null)
                return ResultUtil.Error(ResultEnum.ADD_CASESPHASE_FAIL);
        }
        if (!zdtext.equals("")){
            String filetype = "文字";
            Data data1 = new Data();
            data1.setDatatype("概述");
            data1.setDataname(filetype);
            data1.setContent(zdtext);
            Data data = dataRepository.save(data1);
            if (data==null)
                return ResultUtil.Error(ResultEnum.ADD_DATA_FAIL);
            Integer dataid = data.getDataid();
            CasesPhase casesPhase = casesPhaseRepository.save(new CasesPhase(casesid,"zd",dataid));
            if (casesPhase==null)
                return ResultUtil.Error(ResultEnum.ADD_CASESPHASE_FAIL);
        }
        if (!zltext.equals("")){
            String filetype = "文字";
            Data data1 = new Data();
            data1.setDatatype("概述");
            data1.setDataname(filetype);
            data1.setContent(zltext);
            Data data = dataRepository.save(data1);
            if (data==null)
                return ResultUtil.Error(ResultEnum.ADD_DATA_FAIL);
            Integer dataid = data.getDataid();
            CasesPhase casesPhase = casesPhaseRepository.save(new CasesPhase(casesid,"zl",dataid));
            if (casesPhase==null)
                return ResultUtil.Error(ResultEnum.ADD_CASESPHASE_FAIL);
        }

        return ResultUtil.success("add cases words success");
    }

    public void deleteAllCaseData(Integer casesid){
        List<CasesPhase> casesPhaseList = casesPhaseRepository.findAllByCaseid(casesid);
        for(CasesPhase casesPhase : casesPhaseList){
            dataRepository.deleteById(casesPhase.getDataid());
            casesPhaseRepository.delete(casesPhase);
        }
    }

    public void deleteOneCaseData(Integer casesid,String casephasename){
        List<CasesPhase> casesPhaseList = casesPhaseRepository.findAllByCaseidAndCasephasename(casesid,casephasename);
        for(CasesPhase casesPhase : casesPhaseList){
            dataRepository.deleteById(casesPhase.getDataid());
            casesPhaseRepository.delete(casesPhase);
        }
    }

    public void deleteOneCaseData(Integer dataid) {
        dataRepository.deleteById(dataid);
        CasesPhase casesPhase = casesPhaseRepository.getByDataid(dataid);
        casesPhaseRepository.delete(casesPhase);
    }

    public void updateCasesWords(Integer dataid1, String words1,
                                       Integer dataid2, String words2,
                                       Integer dataid3, String words3,
                                       Integer dataid4, String words4) {
        if (!words1.equals("")){
            com.soft.classwork.model.Data data = dataRepository.getOne(dataid1);
            data.setContent(words1);
            dataRepository.save(data);
        }if (!words2.equals("")){
            com.soft.classwork.model.Data data = dataRepository.getOne(dataid2);
            data.setContent(words2);
            dataRepository.save(data);
        }if (!words3.equals("")){
            com.soft.classwork.model.Data data = dataRepository.getOne(dataid3);
            data.setContent(words3);
            dataRepository.save(data);
        }if (!words4.equals("")){
            com.soft.classwork.model.Data data = dataRepository.getOne(dataid4);
            data.setContent(words4);
            dataRepository.save(data);
        }
    }

    public List<com.soft.classwork.model.Data> getOneCasesAllData(Integer casesid) {
        List<CasesPhase> casesPhaseList = casesPhaseRepository.findAllByCaseid(casesid);
        List<Data> dataList = new LinkedList<>();
        for(CasesPhase casesPhase : casesPhaseList){
            Integer dataid = casesPhase.getDataid();
            Data data = dataRepository.getOne(dataid);
            dataList.add(data);
        }
        return dataList;
    }

    public Result addOneFileData(MultipartFile file, Integer casesid, String casephasename) throws IOException{
        String fileName = file.getOriginalFilename();
        //InputStream inputStreamfile = file.getInputStream();

        String filePath = "";
        filePath=filePath+"/casesid"+casesid;

        File dir = new File("upload/");
        if (!dir.exists()) {
            dir.mkdir();
        }
        if (!fileName.equals("")) {
            filePath=filePath+"/"+casephasename;
            String filetype = FileUtil.checkFileType(fileName);
            Data data1 = new Data();
            data1.setContent(filePath);
            data1.setDataname(fileName);
            data1.setDatatype(filetype);
            Data data = dataRepository.save(data1);
            if (data==null)
                return ResultUtil.Error(ResultEnum.ADD_DATA_FAIL);
            Integer dataid = data.getDataid();
////////////////////////////////////////////////////数据插入
            String path = "upload/" + file.getOriginalFilename();
            try {
                FileUtil.uploadFile(file.getBytes(), "upload/", fileName);
            } catch (Exception e) {
                e.printStackTrace();
                ResultUtil.Error(ResultEnum.UPLOAD_FAIL);
            }
            FtpFileUtil.uploadFile(fileName, new FileInputStream(path),"casesid"+casesid.toString(),casephasename);

            File deletefile = new File(path);
            deletefile.delete();
////////////////////////////////////////////////////数据插入结束
            CasesPhase casesPhase = casesPhaseRepository.save(new CasesPhase(casesid,casephasename,dataid));
            if (casesPhase==null)
                return ResultUtil.Error(ResultEnum.ADD_CASESPHASE_FAIL);

        }
        return ResultUtil.success("文件上传成功！");
    }
}


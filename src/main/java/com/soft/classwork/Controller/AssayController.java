package com.soft.classwork.Controller;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.exception.PetException;
import com.soft.classwork.model.Assay;
import com.soft.classwork.model.Result;
import com.soft.classwork.service.AssayService;
import com.soft.classwork.utils.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/assayManage")
public class AssayController {
    @Autowired
    AssayService assayService;

    @RequestMapping(value = "/addAssay", method = RequestMethod.POST)
    public Result addAssay(@RequestBody Assay assay){
        if(assay.getAssayname()== null){
            throw new PetException(ResultEnum.ASSAY_NAME_NULL);
        }
        if(assay.getDepartment() == null){
            throw new PetException(ResultEnum.ASSAY_DEPARTMENT_NULL);
        }
        return ResultUtil.success(assayService.addAssay(assay));
    }

    @RequestMapping(value = "/updateAssay", method = RequestMethod.POST)
    public Result updateAssay(@RequestBody Assay assay){
        if(assay.getAssayid()==0){
            throw new PetException(ResultEnum.ASSAY_ID_NULL);
        }
        return ResultUtil.success(assayService.updateAssay(assay));
    }

    @RequestMapping(value = "/deleteAssay", method = RequestMethod.GET)
    public Result deleteAssay(@Param("assayid") int assayid){
        if(assayid == 0){
            throw new PetException(ResultEnum.ASSAY_ID_NULL);
        }
        return ResultUtil.success(assayService.deleteAssay(assayid));
    }

    @RequestMapping(value = "/getAssayList", method = RequestMethod.GET)
    public Result getAssayList(){
        return ResultUtil.success(assayService.getAssayList());
    }

    @RequestMapping(value = "/searchByAssayname", method = RequestMethod.GET)
    public Result searchByAsssayname(@Param("assayname") String assayname){
        if(assayname == null){
            throw new PetException(ResultEnum.ASSAY_NAME_NULL);
        }
        String assay_name = "%"+assayname+"%";
        List<Assay> assays = assayService.getAssaysByName(assay_name);
        if(assays.size() == 0){
            return ResultUtil.Error(ResultEnum.SEARCH_NULL);
        }
        return ResultUtil.success(assays);
    }
}

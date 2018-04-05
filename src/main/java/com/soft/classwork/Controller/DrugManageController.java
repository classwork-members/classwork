package com.soft.classwork.Controller;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.exception.PetException;
import com.soft.classwork.model.Drug;
import com.soft.classwork.model.Result;
import com.soft.classwork.service.DrugService;
import com.soft.classwork.utils.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/drugManage")
public class DrugManageController {
    @Autowired
    DrugService drugService;
    @RequestMapping(value = "/addDrug", method = RequestMethod.POST)
    public Result addDrug(@RequestBody Drug drug){
        if(drug.getDrugname() == null){
            throw new PetException(ResultEnum.DRUG_NAME_NULL);
        }
        if(drug.getDrugfee() < 0){
            throw new PetException(ResultEnum.DRUG_FEE_NULL);
        }
        return ResultUtil.success(drugService.addDrug(drug));
    }

    @RequestMapping(value = "/updateDrug", method = RequestMethod.POST)
    public Result updateDrug(@RequestBody Drug drug){
        if(drug.getDrugid() == 0){
            throw new PetException(ResultEnum.DRUG_ID_NULL);
        }
        return ResultUtil.success(drugService.updateDrug(drug));
    }

    @RequestMapping(value = "/deleteDrug", method = RequestMethod.GET)
    public Result deleteDrugById(@Param("drugid") int drugid){
        if(drugid == 0){
            throw new PetException(ResultEnum.DRUG_ID_NULL);
        }
        return ResultUtil.success(drugService.deleteDrugByid(drugid));
    }

    @RequestMapping(value = "/getDrugList", method = RequestMethod.GET)
    public Result getDrugList(){
        return ResultUtil.success(drugService.getDrugList());
    }
}

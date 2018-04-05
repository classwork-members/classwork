package com.soft.classwork.Controller;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.exception.PetException;
import com.soft.classwork.model.Hospitalized;
import com.soft.classwork.model.Result;
import com.soft.classwork.service.HosService;
import com.soft.classwork.utils.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hospitalized")
public class HospitalizedController {
    @Autowired
    HosService hosService;

    @RequestMapping(value = "/addInfo", method = RequestMethod.POST)
    public Result addInfo(@RequestBody Hospitalized hospitalized){
        if(hospitalized.getIllnessname() == null){
            throw new PetException(ResultEnum.ILLNESS_NAME);
        }
        if(hospitalized.getDt_in_hospital() == null){
            throw new PetException(ResultEnum.ILLNESS_IN_TIME);
        }
        return ResultUtil.success(hosService.addInfo(hospitalized));

    }

    @RequestMapping(value = "/modifyHosInfo", method = RequestMethod.POST)
    public Result modifyHosInfo(@RequestBody Hospitalized hospitalized){
        if(hospitalized.getHospitalizedid() == 0){
            throw new PetException(ResultEnum.HOS_ID);
        }
        return ResultUtil.success(hosService.modifyInfo(hospitalized));
    }

    @RequestMapping(value = "/deleteHosInfo", method = RequestMethod.POST)
    public Result deleteHosInfo(@Param("hosid") int hosid){
        if(hosid==0){
            throw new PetException(ResultEnum.HOS_ID);
        }
        return ResultUtil.success(hosService.deleteHosInfo(hosid));
    }

    @RequestMapping(value = "/getHosList", method = RequestMethod.GET)
    public Result getHosList(){
        return ResultUtil.success(hosService.getHosList());
    }
}

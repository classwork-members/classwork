package com.soft.classwork.Controller;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.exception.PetException;
import com.soft.classwork.model.Result;
import com.soft.classwork.model.Vaccine;
import com.soft.classwork.service.VaccineService;
import com.soft.classwork.utils.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/vaccineManage")
public class VaccineManageController {
    @Autowired
    VaccineService vaccineService;
    @RequestMapping(value = "/addVaccine", method = RequestMethod.POST)
    public Result addVaccine(@RequestBody Vaccine vaccine){
        if(vaccine.getVaccinename() == null){
            throw new PetException(ResultEnum.VACCINE_NAME_NULL);
        }
        if(Float.valueOf(vaccine.getFee()) < 0){
            throw new PetException(ResultEnum.VACCINE_FEE_NULL);
        }
        return ResultUtil.success(vaccineService.addVaccine(vaccine));
    }

    @RequestMapping(value = "/updateVaccine", method = RequestMethod.POST)
    public Result updateVaccine(@RequestBody Vaccine vaccine){
        if(vaccine.getVaccineid() < 1){
            throw new PetException(ResultEnum.VACCINE_ID_NULL);
        }
        if(Float.valueOf(vaccine.getFee()) <0){
            throw new PetException(ResultEnum.VACCINE_FEE_NULL);
        }
        return ResultUtil.success(vaccineService.updateVaccine(vaccine));
    }

    @RequestMapping(value = "/deleteVaccine", method = RequestMethod.GET)
    public Result deleteVaccine(@Param("id") int id){
        if(id < 1){
            throw new PetException(ResultEnum.VACCINE_ID_NULL);
        }
        return ResultUtil.success(vaccineService.deleteVaccine(id));
    }

    @RequestMapping(value = "/getVaccineList", method = RequestMethod.GET)
    public Result getVaccineList(){
        return ResultUtil.success(vaccineService.getVaccineList());
    }
}

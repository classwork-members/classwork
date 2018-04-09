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

import java.util.List;

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

    /**
     * 按入院时间查询
     * @param indate
     * @return
     */
    @RequestMapping(value = "/searchByIndate", method = RequestMethod.GET)
    public Result searchByIndate(@Param("indate") String indate){
        if (indate == null){
            throw new PetException(ResultEnum.TIME_NULL);
        }
        String in_date = "%"+indate+"%";
        List<Hospitalized> hospitalizeds = hosService.getHosByIndate(in_date);
        if (hospitalizeds.size() == 0){
            return ResultUtil.Error(ResultEnum.SEARCH_NULL);
        }
        return ResultUtil.success(hospitalizeds);
    }

    /**
     * 按出院时间查询
     * @param outdate
     * @return
     */
    @RequestMapping(value = "/searchByOutdate", method = RequestMethod.GET)
    public Result searchByOutdate(@Param("outdate") String outdate){
        if (outdate == null){
            throw new PetException(ResultEnum.TIME_NULL);
        }
        String out_date = "%"+outdate+"%";
        List<Hospitalized> hospitalizeds = hosService.getHosByOutdate(out_date);
        if (hospitalizeds.size() == 0){
            return ResultUtil.Error(ResultEnum.SEARCH_NULL);
        }
        return ResultUtil.success(hospitalizeds);
    }

    /**
     * 按illnessname查询
     * @param illnessname
     * @return
     */
    @RequestMapping(value = "/searchByIllnessname", method = RequestMethod.GET)
    public Result searchByIllnessname(@Param("illnessname") String illnessname){
        if (illnessname == null){
            throw new PetException(ResultEnum.ILLNESS_NAME);
        }
        String illness_name = "%"+illnessname+"%";
        List<Hospitalized> hospitalizeds = hosService.getHosByIllnessname(illness_name);
        if (hospitalizeds.size() == 0){
            return ResultUtil.Error(ResultEnum.SEARCH_NULL);
        }
        return ResultUtil.success(hospitalizeds);
    }
}

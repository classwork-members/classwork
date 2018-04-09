package com.soft.classwork.Controller;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.exception.PetException;
import com.soft.classwork.model.Charge;
import com.soft.classwork.model.Result;
import com.soft.classwork.service.ChargeService;
import com.soft.classwork.utils.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/chargeManage")
public class ChargeManageController {
    @Autowired
    ChargeService chargeService;
    @RequestMapping(value = "/addCharge", method = RequestMethod.POST)
    public Result addCharge(@RequestBody Charge charge){
        if(Float.valueOf(charge.getPayment())<0){
            throw new PetException(ResultEnum.CHARGE_PAYMENT_NULL);
        }
        if(charge.getPurpose() == null){
            throw new PetException(ResultEnum.CHARGE_PURPOSE_NULL);
        }
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dt_create = dateFormat.format(date);
        String dt_update = dateFormat.format(date);
        charge.setDt_create(dt_create);
        charge.setDt_update(dt_update);
        return ResultUtil.success(chargeService.addCharge(charge));
    }

    @RequestMapping(value = "/updateCharge", method = RequestMethod.POST)
    public Result updateCharge(@RequestBody Charge charge){
        if(charge.getChargeid() == 0){
            throw new PetException(ResultEnum.CHARGE_ID_NULL);
        }
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        charge.setDt_update(dateFormat.format(date));
        return ResultUtil.success(chargeService.updateCharge(charge));
    }

    @RequestMapping(value = "/deleteCharge", method = RequestMethod.GET)
    public Result deleteCharge(@Param("chargeid") int chargeid){
        if(chargeid == 0){
            throw new PetException(ResultEnum.CHARGE_ID_NULL);
        }
        return ResultUtil.success(chargeService.deleteCharge(chargeid));
    }

    @RequestMapping(value = "/getChargeList", method = RequestMethod.GET)
    public Result getChargeList(){
        return ResultUtil.success(chargeService.getChargeList());
    }

    @RequestMapping(value = "searchByDt_create", method = RequestMethod.GET)
    public Result searchByDt_create(@Param("dt_create") String dt_create){
        if(dt_create == null){
            throw new PetException(ResultEnum.TIME_NULL);
        }
        String time = "%"+dt_create+"%";
        List<Charge> chargeList = chargeService.getChargeByDt_create(time);
        if(chargeList.size() == 0){
           return ResultUtil.Error(ResultEnum.SEARCH_NULL);
        }
        return ResultUtil.success(chargeList);
    }

    @RequestMapping(value = "/searchByPayment" , method = RequestMethod.GET)
    public Result searchByPayment(@Param("lowpay")String lowpay, @Param("highpay")String highpay){
        if(lowpay == null || highpay == null){
            throw new PetException(ResultEnum.PAYMENT_NULL);
        }
        float low = Float.valueOf(lowpay);
        float high = Float.valueOf(highpay);
        List<Charge> chargeList = chargeService.getChargeByPayment(low,high);
        if(chargeList.size()==0){
            return ResultUtil.Error(ResultEnum.SEARCH_NULL);
        }
        return ResultUtil.success(chargeList);
    }
}

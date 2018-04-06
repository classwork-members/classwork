package com.soft.classwork.Controller;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.exception.PetException;
import com.soft.classwork.model.Charge;
import com.soft.classwork.model.Result;
import com.soft.classwork.service.ChargeService;
import com.soft.classwork.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        return ResultUtil.success(chargeService.updateCharge(charge));
    }
}

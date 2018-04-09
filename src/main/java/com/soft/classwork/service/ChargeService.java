package com.soft.classwork.service;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.exception.PetException;
import com.soft.classwork.mapper.ChargeMapper;
import com.soft.classwork.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChargeService {
    @Autowired
    ChargeMapper chargeMapper;

    public int addCharge(Charge charge){
        int rs = chargeMapper.addCharge(charge);
        if(rs<1){
            throw new PetException(ResultEnum.INSERT_FAIL);
        }
        return rs;
    }

    public int updateCharge(Charge charge){
        if(chargeMapper.getChargeById(charge.getChargeid())==null){
            throw new PetException(ResultEnum.UPDATE_DATA_NONEXIT);
        }
        int rs = chargeMapper.updateChargeById(charge);
        if(rs==0){
            throw new PetException(ResultEnum.UPDATE_FAIL);
        }
        return rs;
    }

    public int deleteCharge(int id){
        if(chargeMapper.getChargeById(id) == null){
            throw new PetException(ResultEnum.INFO_NOT_EXIT);
        }
        int rs = chargeMapper.deleteChargeById(id);
        if(rs == 0){
            throw new PetException(ResultEnum.DELETE_FAIL);
        }
        return rs;
    }

    public List<Charge> getChargeList(){
        return chargeMapper.getChargeList();
    }

    public List<Charge> getChargeByDt_create(String dt_create){
        return chargeMapper.getChargeByDt_create(dt_create);
    }

    public List<Charge> getChargeByPayment(float low, float high){
        return chargeMapper.getChargeByPayment(low,high);
    }
}

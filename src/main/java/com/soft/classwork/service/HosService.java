package com.soft.classwork.service;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.exception.PetException;
import com.soft.classwork.mapper.HosMapper;
import com.soft.classwork.model.Hospitalized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HosService {
    @Autowired
    HosMapper hosMapper;
    public int addInfo(Hospitalized hospitalized){
        int rs = hosMapper.addInfo(hospitalized);
        if(rs<1){
            throw new PetException(ResultEnum.ADD_HOS_INFO);
        }
        return rs;
    }

    public int modifyInfo(Hospitalized hospitalized){
        int rs = hosMapper.modifyInfo(hospitalized);
        if(rs<1){
            throw new PetException(ResultEnum.UPDATE_HOS_FAIL);
        }
        return rs;
    }

    public int deleteHosInfo(int id){
        int rs = hosMapper.deleteInfo(id);
        if(rs<1){
            throw new PetException(ResultEnum.DELETE_HOS_FAIL);
        }
        return rs;
    }

    public List<Hospitalized> getHosList(){
        return hosMapper.getList();
    }
}

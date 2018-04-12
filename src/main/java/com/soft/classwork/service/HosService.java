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
        if(hosMapper.getHosById(hospitalized.getHospitalizedid()) == null){
            throw new PetException(ResultEnum.NONTASK_ERROR);
        }
        int rs = hosMapper.modifyInfo(hospitalized);
        if(rs<1){
            throw new PetException(ResultEnum.UPDATE_HOS_FAIL);
        }
        return rs;
    }

    public int deleteHosInfo(int id){
        if(hosMapper.getHosById(id) == null){
            throw new PetException(ResultEnum.INFO_NOT_EXIT);
        }
        int rs = hosMapper.deleteInfo(id);
        if(rs<1){
            throw new PetException(ResultEnum.DELETE_HOS_FAIL);
        }
        return rs;
    }

    public List<Hospitalized> getHosList(){
        return hosMapper.getList();
    }

    public List<Hospitalized> getHosByIndate(String indate){
        return hosMapper.getHosByIndate(indate);
    }

    public List<Hospitalized> getHosByOutdate(String outdate){
        return hosMapper.getHosByOutdate(outdate);
    }

    public List<Hospitalized> getHosByIllnessname(String illnessname){
        return hosMapper.getHosByIllnessname(illnessname);
    }

    public int getHosCount(){
        return hosMapper.getHosCount();
    }
}

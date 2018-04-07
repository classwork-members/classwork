package com.soft.classwork.service;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.exception.PetException;
import com.soft.classwork.mapper.VaccineMapper;
import com.soft.classwork.model.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineService {
    @Autowired
    VaccineMapper vaccineMapper;
    public int addVaccine(Vaccine vaccine){
        if(vaccineMapper.getVaccineByName(vaccine.getVaccinename()) != null){
            throw new PetException(ResultEnum.DATA_EXIT);
        }
        int rs = vaccineMapper.addVaccine(vaccine);
        if(rs < 1){
            throw new PetException(ResultEnum.INSERT_FAIL);
        }
        return rs;
    }

    public int updateVaccine(Vaccine vaccine){
        if(vaccineMapper.getVaccineById(vaccine.getVaccineid()) == null){
            throw new PetException(ResultEnum.UPDATE_DATA_NONEXIT);
        }
        int rs = vaccineMapper.updateVaccineById(vaccine);
        if (rs <1){
            throw new PetException(ResultEnum.UPDATE_FAIL);
        }
        return rs;
    }

    public int deleteVaccine(int id){
        if(vaccineMapper.getVaccineById(id) == null){
            throw new PetException(ResultEnum.UPDATE_DATA_NONEXIT);
        }
        int rs = vaccineMapper.deleteVaccineById(id);
        if(rs<1){
            throw new PetException(ResultEnum.DELETE_FAIL);
        }
        return rs;
    }

    public List<Vaccine> getVaccineList(){
        return vaccineMapper.getVaccineList();
    }
}

package com.soft.classwork.service;

import com.soft.classwork.Controller.DrugManageController;
import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.exception.PetException;
import com.soft.classwork.mapper.DrugMapper;
import com.soft.classwork.model.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugService {
    @Autowired
    DrugMapper drugMapper;
    public int addDrug(Drug drug){
        if(drugMapper.getDrugByName(drug.getDrugname())!=null){
            throw new PetException(ResultEnum.DRUG_NAME_EXIT);
        }
        int rs = drugMapper.addDrug(drug);
        if(rs==0){
            throw new PetException(ResultEnum.ADD_DRUG_FAIL);
        }
        return rs;
    }

    public int updateDrug(Drug drug){
        if(drugMapper.getDrugById(drug.getDrugid())==null){
            throw new PetException(ResultEnum.NONTASK_ERROR);
        }
        int rs = drugMapper.updateDrugById(drug);
        if(rs<1){
            throw new PetException(ResultEnum.UPDADE_DRUG_FAIL);
        }
        return rs;
    }

    public int deleteDrugByid(int id){
        if(drugMapper.getDrugById(id) == null){
            throw new PetException(ResultEnum.INFO_NOT_EXIT);
        }
        int rs = drugMapper.deleteDrugByid(id);
        if(rs<1){
            throw new PetException(ResultEnum.DELETE_DRUG_FAIL);
        }
        return rs;
    }

    public List<Drug> getDrugList(){
        return drugMapper.getDrugList();
    }

    public List<Drug> getDrugsByName(String name){
        return drugMapper.getDrugsByName(name);
    }
}

package com.soft.classwork.service;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.exception.PetException;
import com.soft.classwork.mapper.AssayMapper;
import com.soft.classwork.model.Assay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssayService {
    @Autowired
    AssayMapper assayMapper;
    public int addAssay(Assay assay){
        int rs = assayMapper.addAssay(assay);
        if(rs<1){
            throw new PetException(ResultEnum.INSERT_FAIL);
        }
        return rs;
    }

    public int updateAssay(Assay assay){
        if(assayMapper.getAssayById(assay.getAssayid()) == null){
            throw new PetException(ResultEnum.UPDATE_DATA_NONEXIT);
        }
        int rs = assayMapper.updateAssayById(assay);
        if(rs<1){
            throw new PetException(ResultEnum.UPDATE_FAIL);
        }
        return rs;
    }

    public int deleteAssay(int id){
        if(assayMapper.getAssayById(id) == null){
            throw new PetException((ResultEnum.INFO_NOT_EXIT));
        }
        int rs = assayMapper.deleteAssayById(id);
        if(rs<1){
            throw new PetException(ResultEnum.DELETE_FAIL);
        }
        return rs;
    }

    public List<Assay> getAssayList(){
        return assayMapper.getAssayList();
    }

    public List<Assay> getAssaysByName(String name){
        return assayMapper.getAssaysByName(name);
    }

    public int getAssayCount(){
        return assayMapper.getAssayCount();
    }
}

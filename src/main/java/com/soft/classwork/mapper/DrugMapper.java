package com.soft.classwork.mapper;

import com.soft.classwork.model.Drug;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DrugMapper {
    Drug getDrugByName(@Param("drugname") String drugname);
    int addDrug(Drug drug);
    int updateDrugById(@Param("drug")Drug drug);
    int deleteDrugByid(@Param("id") int id);
    Drug getDrugById(@Param("id") int id);
    List<Drug> getDrugList();
    List<Drug> getDrugsByName(@Param("name") String name);
}

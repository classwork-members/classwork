package com.soft.classwork.mapper;

import com.soft.classwork.model.Vaccine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface VaccineMapper {
    int addVaccine(Vaccine vaccine);
    Vaccine getVaccineByName(@Param("name")String name);
    Vaccine getVaccineById(@Param("id") int id);
    int updateVaccineById(@Param("vaccine") Vaccine vaccine);
    int deleteVaccineById(@Param("id") int id);
    List<Vaccine> getVaccineList();
    List<Vaccine> getVaccinesByName(@Param("name")String name);
}

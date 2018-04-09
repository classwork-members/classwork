package com.soft.classwork.mapper;

import com.soft.classwork.model.Hospitalized;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HosMapper {
    int addInfo(@Param("hos") Hospitalized hos);
    int modifyInfo(@Param("hos") Hospitalized hos);
    int deleteInfo(@Param("id") int id);
    List<Hospitalized> getList();
    Hospitalized getHosById(@Param("id") int id);
    List<Hospitalized> getHosByIndate(@Param("indate") String indate);
    List<Hospitalized> getHosByIllnessname(@Param("illnessname") String illnessname);
    List<Hospitalized> getHosByOutdate(@Param("outdate") String outdate);
}

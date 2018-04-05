package com.soft.classwork.mapper;

import com.soft.classwork.model.Hospitalized;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HosMapper {
    int addInfo(@Param("hos") Hospitalized hos);
    int modifyInfo(@Param("hos") Hospitalized hos);
    int deleteInfo(@Param("id") int id);
    List<Hospitalized> getList();
}

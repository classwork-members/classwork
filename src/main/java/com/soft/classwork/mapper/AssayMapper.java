package com.soft.classwork.mapper;

import com.soft.classwork.model.Assay;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface AssayMapper {
    int addAssay(Assay assay);
    int updateAssayById(@Param("assay") Assay assay);
    Assay getAssayById(@Param("id") int id);
    int deleteAssayById(@Param("id") int id);
    List<Assay> getAssayList();
}

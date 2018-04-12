package com.soft.classwork.mapper;

import com.soft.classwork.model.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {
    int insertDept(Department department);
    List<Department> getDepartmentList();
    Department getDeptByName(@Param("deptname") String deptname);
    int updateDept(@Param("dept") Department dept);
    Department getDeptByNameAndId(@Param("deptid") int deptid, @Param("deptname") String deptname);
    Department getDeptById(@Param("deptid") int deptid);
    int deleteDept(@Param("deptid") int deptid);
    List<Department> getDeptsByName(@Param("name")String name);
    int getDeptCount();
}

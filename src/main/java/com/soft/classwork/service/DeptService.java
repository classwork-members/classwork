package com.soft.classwork.service;

import com.soft.classwork.mapper.DeptMapper;
import com.soft.classwork.model.Department;
import com.soft.classwork.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yuukiiii
 * on 2018/3/21 15:07
 */

@Service
public class DeptService {

    @Autowired
    DeptMapper deptMapper ;

    public int addDept(Department department){

        return deptMapper.insertDept(department);
    }

    /*public void deleteDept(Integer deptid){
        deptMapper.deleteById(deptid);
    }

    public List<Department> findAllDept(){
        return deptMapper.findAll();
    }

    public Department findOenDept(Integer deptid){
        return deptMapper.getOne(deptid);
    }

    public Department updateDept(Integer deptid, String deptname, String deptdesc){
        Department department = new Department();
        department.setDeptdesc(deptdesc);
        department.setDeptid(deptid);
        department.setDeptname(deptname);
        return deptMapper.save(department);
    }*/
}

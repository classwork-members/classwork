package com.soft.classwork.service;

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
    DeptRepository deptRepository ;

    public Department addDept(Department department){

        return deptRepository.save(department);
    }

    public void deleteDept(Integer deptid){
        deptRepository.deleteById(deptid);
    }

    public List<Department> findAllDept(){
        return deptRepository.findAll();
    }

    public Department findOenDept(Integer deptid){
        return deptRepository.getOne(deptid);
    }

    public Department updateDept(Integer deptid, String deptname, String deptdesc){
        Department department = new Department();
        department.setDeptdesc(deptdesc);
        department.setDeptid(deptid);
        department.setDeptname(deptname);
        return deptRepository.save(department);
    }
}

package com.soft.classwork.service;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.exception.PetException;
import com.soft.classwork.mapper.DeptMapper;
import com.soft.classwork.model.Department;
import com.soft.classwork.repository.DeptRepository;
import com.soft.classwork.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final static Logger logger = LoggerFactory.getLogger(DeptService.class);

    public int addDept(Department department){
        if(deptMapper.getDeptByName(department.getDeptname())!=null){
            throw new PetException(ResultEnum.INSERT_DEPT1);
        }
        return deptMapper.insertDept(department);
    }

    public List<Department> getDepartmentList(){
        List<Department> list = deptMapper.getDepartmentList();
        for(int i=0; i<list.size();i++){
            Department department = list.get(i);
            String[] arr = StringUtil.StringToArray(department.getDeptprincipal());
            department.setPrincipalArr(arr);
        }
        return list;
    }

    public int updateDept(Department department){
        if(deptMapper.getDeptByNameAndId(department.getDeptid(),department.getDeptname()) == null){
            throw new PetException(ResultEnum.NONTASK_ERROR);
        }
        return deptMapper.updateDept(department);
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

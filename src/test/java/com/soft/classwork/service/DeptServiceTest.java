package com.soft.classwork.service;

import com.soft.classwork.model.Department;
import java.util.List;

import com.soft.classwork.service.DeptService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Yuukiiii
 * on 2018/4/10 00:43
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptServiceTest {

    @Autowired
    private DeptService deptService;

    @Test
    public void addDept() {
        Department department = new Department();
        department.setDeptname("精神病科ww");
        department.setDeptdesc("动物的精神疾病也值得人类关注和研究");
        department.setDeptprincipal("刘璟铄医生");

        Integer test = deptService.addDept(department);
        Assert.assertEquals(new Integer(1),test);

    }

    @Test
    public void getDepartmentList() {
        List<Department> departmentList = deptService.getDepartmentList();
        Integer test = departmentList.size();
        Assert.assertNotNull(test);
    }

    @Test
    public void updateDept() {
        Department department = new Department();
        department.setDeptname("精神病科1711");
        department.setDeptdesc("动物的精神疾病也值得人类关注和研究");
        department.setDeptprincipal("刘璟铄医生");
        department.setDeptid(19);

        Integer test = deptService.addDept(department);
        Assert.assertEquals(new Integer(1),test);
    }

    @Test
    public void deleteDept() {
        Integer test = deptService.deleteDept(8);
        Assert.assertEquals(new Integer(1),test);
    }

    @Test
    public void getDeptsByName() {
        String name = "";
        List<Department> departmentList = deptService.getDeptsByName(name);
        Integer test = departmentList.size();
        Assert.assertEquals(new Integer(0),test);
    }
}
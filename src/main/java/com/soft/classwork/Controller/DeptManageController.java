package com.soft.classwork.Controller;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.model.Department;
import com.soft.classwork.model.Result;
import com.soft.classwork.service.DeptService;
import com.soft.classwork.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/deptManage")
public class DeptManageController {
    @Autowired
    DeptService deptService;
    @RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
    public Result addDepartment(@RequestBody Department department){
        if(department == null){
            return ResultUtil.Error(ResultEnum.REQUEST_NULL);
        }else if(department.getDeptname()==null){
            return ResultUtil.Error(ResultEnum.DEPT_NAME);
        }
        if(deptService.addDept(department)<1){
            return ResultUtil.Error(ResultEnum.INSERT_DEPT);
        }
        return ResultUtil.success();
    }
}

package com.soft.classwork.Controller;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.exception.PetException;
import com.soft.classwork.model.Department;
import com.soft.classwork.model.Result;
import com.soft.classwork.service.DeptService;
import com.soft.classwork.utils.ResultUtil;
import com.soft.classwork.utils.StringUtil;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/deptManage")
public class DeptManageController {
    private final static Logger logger = LoggerFactory.getLogger(DeptManageController.class);
    @Autowired
    DeptService deptService;
    @RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
    public Result addDepartment(@RequestBody Department department){
        logger.debug("_______________principal:"+department.getDeptprincipal()+"_____________");
        if(department.getDeptname() == null){
            return ResultUtil.Error(ResultEnum.DEPT_NAME);
        }

        if(deptService.addDept(department)<1){
            return ResultUtil.Error(ResultEnum.INSERT_DEPT);
        }
        return ResultUtil.success();
    }

    @RequestMapping(value = "/getDepartmentList", method = RequestMethod.GET)
    public Result getDepartmentList(){
        return ResultUtil.success( deptService.getDepartmentList());
    }

    @RequestMapping(value = "/updateDept",method = RequestMethod.POST)
    public Result updateDept(@RequestBody Department department){
        if(department == null){
            throw new PetException(ResultEnum.REQUEST_NULL);
        }
        if(department.getDeptname()==null){
            throw new PetException(ResultEnum.DEPT_NAME);
        }
        if(department.getPrincipalArr()==null){
            throw new PetException(ResultEnum.DEPT_PRIN);
        }
        department.setDeptprincipal(StringUtil.ArrayToString(department.getPrincipalArr()));
        return ResultUtil.success(deptService.updateDept(department));
    }

    @RequestMapping(value = "/reduceDept", method = RequestMethod.POST)
    public Result deleteDept(@Param("deptid") int deptid){
        if(deptid == 0){
            throw new PetException(ResultEnum.DEPT_ID);
        }
        return ResultUtil.success(deptService.deleteDept(deptid));
    }
}
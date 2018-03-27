package com.soft.classwork.Controller;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.model.Result;
import com.soft.classwork.service.UserService;
import com.soft.classwork.utils.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userManage")
public class UserManageController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public Result Register(@Param("username") String username, @Param("password")String password){
        int i = userService.register(username, password);
        if (i == 1) {
            return ResultUtil.success("注册成功!");
        } else if (i == -1) {
            return ResultUtil.Error(ResultEnum.REGISTER_FAIL1);
        }
        return ResultUtil.Error(ResultEnum.REGISTER_FAIL2);
    }
}

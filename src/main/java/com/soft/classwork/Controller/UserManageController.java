package com.soft.classwork.Controller;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.model.Result;
import com.soft.classwork.model.User;
import com.soft.classwork.service.UserService;
import com.soft.classwork.utils.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userManage")
public class UserManageController {
    private final static Logger logger = LoggerFactory.getLogger(UserManageController.class);
    @Autowired
    UserService userService;
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public Result register(@Param("username") String username, @Param("password")String password, @Param("email")String email, @Param("Gender")String gender,@Param("role")String role ){
        logger.debug("__________________username: "+username+"___________password:"+password+"_______email:"+email+"______gender:"+gender+"__________role:"+role+"_______________");
        //return ResultUtil.success();
        int i = userService.register(username, password,email,role);
        logger.debug("_____________i:"+i+"_________");
        if (i == 1) {
            return ResultUtil.success("注册成功!");
        } else if (i == -1) {
            return ResultUtil.Error(ResultEnum.REGISTER_FAIL1);
        }
        return ResultUtil.Error(ResultEnum.REGISTER_FAIL2);
    }
    @RequestMapping(value="/userList",method = RequestMethod.GET)
    public Result getUserList(){
        List<User> userList = userService.getUserList();
        if( userList == null){
            return ResultUtil.Error(ResultEnum.GETDARA_FAIL);
        }
        return ResultUtil.success(userList);
    }

    @RequestMapping(value="/modifyuserinfo",method = RequestMethod.POST)
    public Result updateUserInfoById(@Param("userid")int userid,@Param("username") String username, @Param("password")String password, @Param("email")String email,@Param("role")String role){
        int rs = userService.updateUserInfoById(userid,username,password,email,role);
        return ResultUtil.success(rs);
    }

    @RequestMapping(value="/deleteuser",method = RequestMethod.POST)
    public Result deleteUserByUserId(@Param("userid") int userid){
        int rs = userService.deleteUserByUserId( userid);
        return ResultUtil.success(rs);
    }
}

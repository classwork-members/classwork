package com.soft.classwork.Controller;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.exception.PetException;
import com.soft.classwork.model.Result;
import com.soft.classwork.model.User;
import com.soft.classwork.service.UserService;
import com.soft.classwork.utils.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserManageController {
    private final static Logger logger = LoggerFactory.getLogger(UserManageController.class);

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/userManage/signin", method = RequestMethod.POST)
    public Result register(@Param("username") String username, @Param("password")String password, @Param("email")String email, @Param("Gender")String gender, @Param("role")String role ){
        logger.debug("__________________username: "+username+"___________password:"+password+"_______email:"+email+"______gender:"+gender+"__________role:"+role+"_______________");
        //return ResultUtil.success();

        int i = userService.register(username, password,email,role);
        logger.debug("_____________i:"+i+"_________");
        if (i == 1) {
            return ResultUtil.success("注册成功!");
           // model.addAttribute("msg",0);
           // return "redirect:/manageUser.html";
        } else if (i == -1) {
            return ResultUtil.Error(ResultEnum.REGISTER_FAIL1);
            //model.addAttribute("msg",1);
            //return "redirect:/manageUser.html";
        }
        return ResultUtil.Error(ResultEnum.REGISTER_FAIL2);
        //model.addAttribute("msg",2);
        //return "redirect:/manageUser.html";
    }

    @ResponseBody
    @RequestMapping(value="/userManage/userList",method = RequestMethod.GET)
    public Result getUserList(){
        List<User> userList = userService.getUserList();
        if( userList == null){
            return ResultUtil.Error(ResultEnum.GETDARA_FAIL);
        }
        return ResultUtil.success(userList);
    }

    @ResponseBody
    @RequestMapping(value="/userManage/modifyuserinfo",method = RequestMethod.POST)
    public Result updateUserInfoById(@Param("userid")int userid,@Param("username") String username, @Param("password")String password, @Param("email")String email,@Param("role")String role){
        int rs = userService.updateUserInfoById(userid,username,password,email,role);
        return ResultUtil.success(rs);
    }

    @ResponseBody
    @RequestMapping(value="/userManage/deleteuser",method = RequestMethod.POST)
    public Result deleteUserByUserId(@Param("userid") int userid){
        int rs = userService.deleteUserByUserId( userid);
        return ResultUtil.success(rs);
    }

    @ResponseBody
    @RequestMapping(value = "/userManage/searchByUsername", method = RequestMethod.GET)
    public Result searchByUsername(@Param("username") String username){
        if (username == null){
            throw new PetException(ResultEnum.USERNSMR_NULL);
        }
        String user_name = "%"+username+"%";
        List<User> users = userService.getUsersByUsername(user_name);
        if(users.size() == 0){
            return ResultUtil.Error(ResultEnum.SEARCH_NULL);
        }
        return ResultUtil.success(users);
    }
}

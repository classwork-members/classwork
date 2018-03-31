package com.soft.classwork.service;

import com.soft.classwork.enums.ResultEnum;
import com.soft.classwork.exception.PetException;
import com.soft.classwork.mapper.UserMapper;
import com.soft.classwork.model.Role;
import com.soft.classwork.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserService implements UserDetailsService{
    @Autowired
    UserMapper userMapper;

    private final static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        logger.debug("name is ______________"+name+"------------------");
        User user = userMapper.loadUserByUsername(name);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不对");
        }
        return user;
    }

    @Transactional
    public int register(String username, String password, String email, String rolename){
        //如果用户名存在，返回错误
        if (userMapper.loadUserByUsername(username) != null) {
            return -1;
        }
        logger.debug("______"+rolename.substring(0,5)+"_____________");
        if(!rolename.substring(0,5).equals("ROLE_")){
            rolename = "ROLE_"+ rolename;
        }
        System.out.println("_________________roleName:"+rolename+"_______________________");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(password);
        int rs =  userMapper.register(username, encode, email);
        if(rs!=0){
            User user = userMapper.getUserByName(username);
            if(user == null){
                throw new PetException(ResultEnum.USER_DATA_FAIL);
            }
            Role role = userMapper.getRoleByRoleName(rolename);
            if(role == null){
                throw new PetException(ResultEnum.ROLE_DATA_FAIL);
            }
            if(userMapper.setRole(user.getUserid(), role.getRoleid())==0){
                throw new PetException(ResultEnum.INSERT_FAIL);
            }
        }else{
            throw new PetException((ResultEnum.INSERT_FAIL));
        }
        return rs;
    }

    @Transactional
    public int updateUserInfoById(int userid, String username, String password, String email,String roleName){
        User user = userMapper.getUserById(userid);
        if(!roleName.substring(0,5).equals("ROLE_")){
            roleName = "ROLE_"+ roleName;
        }
        System.out.println("_________________roleName:"+roleName+"_______________________");
        if(user != null){
            Role role = userMapper.getRoleByRoleName(roleName);
            if(role==null){
                throw new PetException(ResultEnum.ROLE_DATA_FAIL);
            }
            System.out.println("_________________roleId:"+role.getRoleid()+"_______________________"+role.getRolename());
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encode = encoder.encode(password);
            user.setUsername(username);
            user.setPassword(encode);
            user.setEmail(email);
            int rs = userMapper.updateUserInfo(user);
            if(rs == 0 ){
                throw new PetException(ResultEnum.UPDATE_FAIL);
            }
            rs = userMapper.updateUserRole(user.getUserid(),role.getRoleid());
            if(rs == 0 ){
                throw new PetException(ResultEnum.UPDATE_FAIL);
            }
            return rs;
        }else{
            throw new PetException(ResultEnum.USER_NULL);
        }
    }

    public List<User> getUserList(){
        return userMapper.getUserList();
    }

    public int deleteUserByUserId(int userid){
        int rs = userMapper.deleteUserByUserId(userid);
        if(rs == 0){
            throw new PetException(ResultEnum.DELETE_USER_FAIL);
        }
        rs = userMapper.deleteUserRolesByUserId(userid);
        if(rs == 0){
            throw new PetException(ResultEnum.DELETE_USERROLE_FAIL);
        }
        return rs;
    }
}

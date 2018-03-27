package com.soft.classwork.mapper;

import com.soft.classwork.model.Role;
import com.soft.classwork.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User loadUserByUsername(String username);
    List<Role> getRolesByHrId(Long id);
    int register(@Param("username") String username, @Param("password") String password);
}

package com.soft.classwork.mapper;

import com.soft.classwork.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User loadUserByUsername(@Param("username") String username);
}

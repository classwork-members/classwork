package com.soft.classwork.mapper;

import com.soft.classwork.model.Role;
import com.soft.classwork.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User loadUserByUsername(String username);
    User getUserById(int userid);
    User getUserByName(String username);
    List<Role> getRolesByHrId(Long id);
    int setRole(@Param("user_id")int user_id,@Param("role_id") int role_id);
    int register(@Param("username") String username, @Param("password") String password, @Param("email")String email);
    List<User> getUserList();
    Role getRoleByRoleName(String roleName);
    int updateUserInfo(@Param("user")User user);
    int updateUserRole(@Param("user_id")int user_id,@Param("roles_id") int roles_id);
    int deleteUserByUserId(@Param("userid")int userid);
    int deleteUserRolesByUserId(@Param("user_id") int user_id);
    List<User> getUsersByName(@Param("username") String username);
}

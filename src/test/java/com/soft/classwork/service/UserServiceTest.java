package com.soft.classwork.service;

import com.soft.classwork.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.Max;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Test
    public void loadUserByUsername() {
        UserDetails user = userService.loadUserByUsername("ljs");
        Assert.assertNotNull(user);
    }

    @Test
    public void register() {
        int rs = userService.register("sdf","123","lj@qq.com","admin");
        Assert.assertEquals(1,rs);
    }

    @Test
    public void updateUserInfoById() {
        int rs = userService.updateUserInfoById(1,"test1","321","ljs@qq.com","ROLE_admin");
        Assert.assertNotEquals(0,rs);
    }

    @Test
    public void getUserList() {
        List list = userService.getUserList();
        Assert.assertNotNull(list);
    }

    @Test
    public void deleteUserByUserId() {
        int rs = userService.deleteUserByUserId(57);
        Assert.assertEquals(1,rs);
    }

    @Test
    public void getUsersByUsername() {
        List user = userService.getUsersByUsername("test2");
        Assert.assertNotNull(user);
    }
}
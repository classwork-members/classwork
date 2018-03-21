package com.soft.classwork.service;

import com.soft.classwork.mapper.UserMapper;
import com.soft.classwork.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService implements UserDetailsService{
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(name);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不对");
        }
        return user;
    }
}

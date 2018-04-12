package com.soft.classwork.service;

import com.soft.classwork.model.BigUserTest;
import com.soft.classwork.model.UserTest;
import com.soft.classwork.repository.TestRepository;
import com.soft.classwork.repository.UserTestRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Yuukiiii
 * on 2018/4/12 10:34
 */

@Service
public class UserTestService {

    @Autowired
    private UserTestRepository userTestRepository;
//    @Autowired
//    private TestRepository testRepository;
//

    public UserTest addUserTest(UserTest userTest){
        return userTestRepository.save(userTest);
    }

    public void deleteUserTestByUseridAndTestid(Integer userid,Integer testid){
        userTestRepository.deleteByUseridAndTestid(userid,testid);
    }

    public List<UserTest> getAllUserTest(){
        return userTestRepository.findAll();
    }

    public UserTest getOneUserTestById(Integer userid,Integer testid){
        return userTestRepository.findByUseridAndTestid(userid,testid);
    }

    public UserTest updateUserTest(UserTest userTest){
        return userTestRepository.save(userTest);
    }
}

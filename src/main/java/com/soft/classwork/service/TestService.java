package com.soft.classwork.service;

import com.soft.classwork.model.Test;
import java.util.List;

import com.soft.classwork.repository.ExamRepository;
import com.soft.classwork.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Yuukiiii
 * on 2018/4/5 15:53
 */


public class TestService {

    @Autowired
    TestRepository testRepository;

    @Autowired
    ExamRepository examRepository;

    public List<Test> getAllTest(){

    }
}

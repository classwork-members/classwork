package com.soft.classwork.repository;

import com.soft.classwork.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

/**
 * Created by Yuukiiii
 * on 2018/4/5 15:53
 */


public interface TestRepository extends JpaRepository<Test,Integer>{


    public List<Test> findAllByTestnameContaining(String testname);
}

package com.soft.classwork.repository;

import com.soft.classwork.model.TestExam;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Yuukiiii
 * on 2018/4/6 13:52
 */


public interface TestExamRepository extends JpaRepository<TestExam,Integer>{

    public List<TestExam> findAllByTestid(Integer testid);
}

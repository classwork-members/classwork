package com.soft.classwork.repository;

import com.soft.classwork.model.Exam;
import com.soft.classwork.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Yuukiiii
 * on 2018/3/22 08:41
 */


public interface ExamRepository extends JpaRepository<Exam,Integer> {

    public List<Exam> findAllByIllnessid(Integer illnessid);

    public Integer countAllByIllnessid(Integer illnessid);

    public List<Integer> findByIllnessid(Integer illnessid);

    public List<Exam> findAllByQuestionContaining(String examname);

}

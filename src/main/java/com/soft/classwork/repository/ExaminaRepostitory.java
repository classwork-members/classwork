package com.soft.classwork.repository;

import com.soft.classwork.model.Examination;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Yuukiiii
 * on 2018/4/7 13:49
 */


public interface ExaminaRepostitory extends JpaRepository<Examination,Integer>{

    public List<Examination> findAllByExaminationnameContaining(String name);
}

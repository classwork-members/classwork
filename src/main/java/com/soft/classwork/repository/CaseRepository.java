package com.soft.classwork.repository;

import com.soft.classwork.model.Cases;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Yuukiiii
 * on 2018/3/27 15:20
 */


public interface CaseRepository extends JpaRepository<Cases,Integer>{

    public List<Cases> findCasesByIllnessid(Integer illnessid);

    public List<Cases> findAllByCasenameContaining(String casename);

    public List<Cases> findAllByCasenameContainingAndIllnessid(String casename,Integer illnessid);

}

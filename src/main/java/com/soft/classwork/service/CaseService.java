package com.soft.classwork.service;

import com.soft.classwork.model.Cases;
import com.soft.classwork.repository.CaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yuukiiii
 * on 2018/3/27 15:21
 */

@Service
public class CaseService {
    @Autowired
    CaseRepository caseRepository;

    Logger logger = LoggerFactory.getLogger(CaseService.class);

    public List<Cases> findCasesByIllnessid(Integer illnessId){
        return caseRepository.findCasesByIllnessid(illnessId);
    }

//    public String addCases(String casename,
//                           String datetime,
//                           )
}


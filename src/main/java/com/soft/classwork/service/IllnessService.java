package com.soft.classwork.service;

import com.soft.classwork.model.Illness;
import com.soft.classwork.repository.IllnessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Yuukiiii
 * on 2018/4/21 14:00
 */

@Service
public class IllnessService {

    @Autowired
    IllnessRepository illnessRepository;

    public Illness getOneIllness(Integer illnessid){
        return illnessRepository.getOne(illnessid);
    }
}

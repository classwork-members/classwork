package com.soft.classwork.service;

import com.soft.classwork.model.Apparatus;
import com.soft.classwork.repository.AppaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Yuukiiii
 * on 2018/3/22 09:53
 */


public class AppaService {

    @Autowired
    AppaRepository appaRepository;

    public Apparatus addAppa(Apparatus apparatus) {
        return appaRepository.save(apparatus);
    }

    public void deleteAppa(Integer appaid) {
        appaRepository.deleteById(appaid);
    }

    public List<Apparatus> findAllAppa() {
        return appaRepository.findAll();
    }

    public Apparatus findOneAppa(Integer appaid) {
        return appaRepository.getOne(appaid);
    }

    public Apparatus updateAppa(Integer appaid,
                                String appaname,
                                String appadesc) {
        Apparatus apparatus = new Apparatus();
        apparatus.setAppadesc(appadesc);
        apparatus.setAppaid(appaid);
        apparatus.setAppaname(appaname);
        return appaRepository.save(apparatus);
    }
}

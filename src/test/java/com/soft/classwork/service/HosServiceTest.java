package com.soft.classwork.service;

import com.soft.classwork.model.Hospitalized;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Yuukiiii
 * on 2018/4/10 00:40
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class HosServiceTest {

    @Autowired
    private HosService hosService;

    @Test
    public void addInfo() {
        Hospitalized hospitalized = new Hospitalized();
        hospitalized.setIllnessname("心肌炎");
        hospitalized.setDt_in_hospital("2018-02-1 12:00:08");
        hospitalized.setDt_out_hospital("2018-02-13 23:00:00");
        Integer test = hosService.addInfo(new Hospitalized());
        Assert.assertEquals(new Integer(1),test);
    }

    @Test
    public void modifyInfo() {
        Hospitalized hospitalized = new Hospitalized();
        ////////
        hospitalized.setHospitalizedid(1);
        hospitalized.setIllnessname("心脏病");
        Integer test = hosService.modifyInfo(hospitalized);
        Assert.assertEquals(new Integer(1),test);
    }

    @Test
    public void deleteHosInfo() {
        ///////////
        Integer test = hosService.deleteHosInfo(3);
        Assert.assertEquals(new Integer(1),test);
    }

    @Test
    public void getHosList() {
        Assert.assertNotNull(hosService.getHosList());
    }
}

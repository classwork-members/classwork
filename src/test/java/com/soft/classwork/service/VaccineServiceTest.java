package com.soft.classwork.service;

import com.soft.classwork.model.Vaccine;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class VaccineServiceTest {

    @Autowired
    VaccineService vaccineService;
    @Test
    public void addVaccine() {
        Vaccine vaccine = new Vaccine();
        vaccine.setVaccinename("流感疫苗");
        vaccine.setPurpose("治疗流感");
        vaccine.setFee("200");
        int rs = vaccineService.addVaccine(vaccine);
        Assert.assertEquals(1,rs);
    }

    @Test
    public void updateVaccine() {
        Vaccine vaccine = new Vaccine();
        vaccine.setVaccineid(1);
        vaccine.setFee("300");
        int rs = vaccineService.updateVaccine(vaccine);
        Assert.assertEquals(1,rs);
    }

    @Test
    public void deleteVaccine() {
        int rs = vaccineService.deleteVaccine(3);
        Assert.assertEquals(1,rs);
    }

    @Test
    public void getVaccineList() {
        List list = vaccineService.getVaccineList();
        Assert.assertNotNull(list);
    }

    @Test
    public void getVaccineByName() {
        List list = vaccineService.getVaccineByName("流");
        Assert.assertNotNull(list);
    }
}
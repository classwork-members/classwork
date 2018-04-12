package com.soft.classwork.service;

import com.soft.classwork.model.Drug;
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
public class DrugServiceTest {

    @Autowired
    DrugService drugService;

    @Test
    public void addDrug() {
        Drug drug = new Drug();
        drug.setDrugname("半夜不睡觉");
        drug.setDrugdesc("嗨翻天");
        drug.setDrugfee("234");
        int rs = drugService.addDrug(drug);
        Assert.assertEquals(1,rs);
    }

    @Test
    public void updateDrug() {
        Drug drug = new Drug();
        drug.setDrugid(9);
        drug.setDrugname("聊到爆");
        drug.setDrugfee("23");
        drug.setDrugdesc("嗨嗨");
        int rs = drugService.updateDrug(drug);
        Assert.assertEquals(1,rs);
    }

    @Test
    public void deleteDrugByid() {
        int rs = drugService.deleteDrugByid(9);
        Assert.assertEquals(1,rs);
    }

    @Test
    public void getDrugList() {
        List list = drugService.getDrugList();
        Assert.assertNotNull(list);
    }

    @Test
    public void getDrugsByName() {
        List list = drugService.getDrugsByName("半");
        Assert.assertNotNull(list);
    }
}
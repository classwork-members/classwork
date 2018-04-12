package com.soft.classwork.service;

import com.soft.classwork.model.Charge;
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
public class ChargeServiceTest {
    @Autowired
    ChargeService chargeService;
    @Test
    public void addCharge() {
        Charge charge = new Charge();
        charge.setPurpose("治疗失眠多梦");
        charge.setDt_create("2018-04-03 23:00:23");
        charge.setDt_update("2018-04-03 23:00:23");
        charge.setPayment("444");
        int rs = chargeService.addCharge(charge);
        Assert.assertEquals(1,rs);
    }

    @Test
    public void updateCharge() {
        Charge charge = new Charge();
        charge.setChargeid(6);
        charge.setPayment("233");
        charge.setDt_update("2018-06-03 12:34:38");
        int rs = chargeService.updateCharge(charge);
        Assert.assertEquals(1,rs);
    }

    @Test
    public void deleteCharge() {
        int rs = chargeService.deleteCharge(6);
        Assert.assertEquals(1,rs);
    }

    @Test
    public void getChargeList() {
        List ls = chargeService.getChargeList();
        Assert.assertNotNull(ls);
    }

    @Test
    public void getChargeByDt_create() {
        List ls = chargeService.getChargeByDt_create("2018");
        Assert.assertNotNull(ls);
    }

    @Test
    public void getChargeByPayment() {
        List ls = chargeService.getChargeByPayment(10,400);
        Assert.assertNotNull(ls);
    }
}
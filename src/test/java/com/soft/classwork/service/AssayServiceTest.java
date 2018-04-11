package com.soft.classwork.service;

import com.soft.classwork.model.Assay;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.Null;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Yuukiiii
 * on 2018/4/10 01:39
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssayServiceTest {

    @Autowired
    private AssayService assayService;

    @Test
    public void addAssay() {
        Assay assay = new Assay();
        assay.setAssayname("肺部x光");
        assay.setAssaydesc("dfkjh");
        assay.setDepartment("内科");
        Integer test = assayService.addAssay(assay);
        Assert.assertEquals(new Integer(1),test);
    }

    @Test
    public void updateAssay() {
        Assay assay = new Assay();
        /////////////
        assay.setAssayid(1);
        assay.setAssaydesc("kds");
        Integer test = assayService.updateAssay(assay);
        Assert.assertEquals(new Integer(1),test);
    }

    @Test
    public void deleteAssay() {
        ////////
        Integer test = assayService.deleteAssay(1);
        ////////
        Assert.assertEquals(new Integer(1),test);

    }

    @Test
    public void getAssayList() {
        ///////////
      List list = assayService.getAssayList();
        ///////////
        Assert.assertNotNull(list);
    }

    @Test
    public void getAssaysByName() {
        ////////
        List list = assayService.getAssaysByName("肺部x光");
        Assert.assertNotNull(list);
        ////////
    }
}

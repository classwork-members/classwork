package com.soft.classwork.Controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DeptManageControllerTest {

    @Autowired
    MockMvc mvc;
    @Test
    public void addDepartment() {
    }

    @Test
    public void getDepartmentList() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/getDepartmentList"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void updateDept() {
    }

    @Test
    public void deleteDept() {
    }

    @Test
    public void searchByDeptName() {
    }
}
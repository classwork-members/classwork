package com.soft.classwork.model;

/**
 * Created by Yuukiiii
 * on 2018/4/12 10:42
 */


public class BigUserTest {

    private UserTest userTest;
    private String username;
    private String testname;

    public BigUserTest(UserTest userTest, String username, String testname) {
        this.userTest = userTest;
        this.username = username;
        this.testname = testname;
    }

    public BigUserTest() {
    }

    public UserTest getUserTest() {
        return userTest;
    }

    public void setUserTest(UserTest userTest) {
        this.userTest = userTest;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }
}

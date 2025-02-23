package com.thetestingacademy.TestNGExamples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITest013_TestNG {
    @BeforeTest
    public String getToken(){
        return "";
    }

    @BeforeTest
    public String getBooking(){
        return "";
    }

    @Test(priority = 1)
    public void test_get_request(){}

    @Test(priority = 2)
    public void test_post_request(){}

    @Test(priority = 3)
    public void test_put_request(){}

    @AfterTest
    public void close(){
        System.out.println("Close");
    }
}

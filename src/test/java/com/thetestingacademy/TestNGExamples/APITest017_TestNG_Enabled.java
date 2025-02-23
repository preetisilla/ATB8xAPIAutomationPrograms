package com.thetestingacademy.TestNGExamples;

import org.testng.annotations.Test;

public class APITest017_TestNG_Enabled {
    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test(enabled = false)
    public void test2(){
        System.out.println("test2");
    }

    @Test
    public void test3(){
        System.out.println("test3");
    }
}

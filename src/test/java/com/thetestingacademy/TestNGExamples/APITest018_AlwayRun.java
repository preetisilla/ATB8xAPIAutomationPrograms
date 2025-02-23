package com.thetestingacademy.TestNGExamples;

import org.testng.annotations.Test;

public class APITest018_AlwayRun {
    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test(alwaysRun = true)
    public void test2(){
        System.out.println("test2");
    }

    @Test
    public void test3(){
        System.out.println("test3");
    }
}

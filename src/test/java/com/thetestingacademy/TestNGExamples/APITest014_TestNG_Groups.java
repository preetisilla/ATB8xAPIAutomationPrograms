package com.thetestingacademy.TestNGExamples;

import org.testng.annotations.Test;

import javax.swing.*;

public class APITest014_TestNG_Groups {
    @Test(groups = {"qa","reg","smoke"})
    public void test1(){
        System.out.println("qa test 1");
    }

    @Test(groups = {"smoke","reg"})
    public void test2(){
        System.out.println("smoke test");
    }

    @Test(groups = {"qa"})
    public void test3(){
        System.out.println("qa test 2");
    }
}

package com.thetestingacademy.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITest020_Assertions {
    @Test
    public void test_HardAssertions(){
        System.out.println("Start Execution");
        Assert.assertTrue(false);
        System.out.println("End Execution");
    }

    @Test
    public void test_SoftAssertions(){
        System.out.println("Start soft execution");
        SoftAssert sf = new SoftAssert();
        sf.assertTrue(false);
        System.out.println("I will execute");
        sf.assertAll();
    }

}

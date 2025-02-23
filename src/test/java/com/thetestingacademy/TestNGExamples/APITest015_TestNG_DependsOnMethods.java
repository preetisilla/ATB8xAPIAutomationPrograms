package com.thetestingacademy.TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest015_TestNG_DependsOnMethods {
    @Test
    public void serverStartedOK(){
        System.out.println("Server Started ok");
    }

    @Test(dependsOnMethods = "serverStartedOK")
    public void method1(){
        System.out.println("method1");
        Assert.assertTrue(true);
    }
}

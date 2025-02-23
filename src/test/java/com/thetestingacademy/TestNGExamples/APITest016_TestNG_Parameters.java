package com.thetestingacademy.TestNGExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITest016_TestNG_Parameters {
    @Parameters("browser")
    @Test
    void demo1(String value){
        System.out.println("browser is "+value);
        if(value.equalsIgnoreCase("chrome")){
            System.out.println("Start my Chrome");
        }
        else if(value.equalsIgnoreCase("Firefox")){
            System.out.println("Start my Firefox");
        }
    }
}

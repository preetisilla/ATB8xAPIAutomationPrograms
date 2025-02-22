package com.thetestingacademy.RestAssuredBasics;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITest005_NonBDDStyleGET {
    RequestSpecification r = RestAssured.given();
    @Severity(SeverityLevel.BLOCKER)
    @Description("TC1 - NONBDDStyleGET - Positive Testcase")
    @Test
    public void test_NonBDDStyleGET_Positive(){
        String pin_code = "560087";
        r.baseUri("https://api.zippopotam.us/");
        r.basePath("/IN/"+pin_code);
        r.when().log().all().get();
        r.then().log().all().statusCode(200);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("TC1 - NONBDDStyleGET - Negative Testcase")
    @Test
    public void test_NonBDDStyleGET_Negative(){
        String pin_code = "-1";
        r.baseUri("https://api.zippopotam.us/");
        r.basePath("/IN/"+pin_code);
        r.when().log().all().get();
        r.then().log().all().statusCode(200);
    }
}

package com.thetestingacademy.RestAssuredBasics.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITest004_BDDStyleGET {
    @Test
    public void test_GET_Request_Positive(){
        String pin_code = "560087";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("/IN/"+pin_code)
                .when().log().all()
                .get()
                .then().log().all()
                .statusCode(200);
    }
    @Test
    public void test_GET_Request_Negative(){
        String pin_code = "-1";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("/IN/"+pin_code)
                .when().log().all()
                .get()
                .then().log().all()
                .statusCode(200);
    }
}

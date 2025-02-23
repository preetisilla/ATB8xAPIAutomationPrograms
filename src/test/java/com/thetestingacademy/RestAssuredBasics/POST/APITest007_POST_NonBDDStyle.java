package com.thetestingacademy.RestAssuredBasics.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITest007_POST_NonBDDStyle {
    // url https://restful-booker.herokuapp.com/auth

    // header Content-Type : application/json

    // Body {
    //    "username" : "admin",
    //    "password" : "password123"
    //}

    @Description("TEST POST NonBDDSTyle")
    @Test
    public void test_Post_NonBDDStyle(){
        String payload = "{\n" +
                "\"username\" : \"admin\",\n" +
                "\"password\" : \"password123\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON).log().all();
        r.body(payload);
        r.when().log().all().post();
        r.then().log().all().statusCode(200);
    }
}

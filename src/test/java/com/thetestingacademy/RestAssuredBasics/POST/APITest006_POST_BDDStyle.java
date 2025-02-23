package com.thetestingacademy.RestAssuredBasics.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class APITest006_POST_BDDStyle {
    // url https://restful-booker.herokuapp.com/auth

    // header Content-Type : application/json

    // Body {
    //    "username" : "admin",
    //    "password" : "password123"
    //}

    @Description("TEST POST BDDSTyle")
    @Test
    public void test_Post_BDDStyle(){
        String payload = "{\n" +
                "\"username\" : \"admin\",\n" +
                "\"password\" : \"password123\"\n" +
                "}";
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/auth")
                    .contentType(ContentType.JSON)
                    .log().all().body(payload)
                .when()
                    .log().all()
                    .post()
                .then().log().all()
                    .statusCode(200);
    }
}

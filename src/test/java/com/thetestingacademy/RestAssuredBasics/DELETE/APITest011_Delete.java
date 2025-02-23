package com.thetestingacademy.RestAssuredBasics.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITest011_Delete {
    @Test
    public void test_delete_request() {
        String bookingId = "3684";
        String token ="b6580f15e666a73";
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingId);
        r.contentType(ContentType.JSON);
        r.cookie(token);

        r.when().delete();

        r.then().log().all().statusCode(200);
    }
}

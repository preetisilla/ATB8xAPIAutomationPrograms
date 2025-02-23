package com.thetestingacademy.RestAssuredBasics.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class APITest009_PATCH_NonBDDStyle {
    //url booking id
    //tokem
    //payload / body

    public void test_PATCH_NonBDDStyle(){
        String token = "b6580f15e666a73";
        String bookingId = "4";
        String payload = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingId);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
//        r.auth().preemptive().basic("username","password123");
//        r.auth().oauth("vhdsf66334567");
        r.body(payload).log().all();

        Response res = r.when().patch();

        ValidatableResponse vr = res.then().log().all();
        vr.statusCode(200);
    }
}

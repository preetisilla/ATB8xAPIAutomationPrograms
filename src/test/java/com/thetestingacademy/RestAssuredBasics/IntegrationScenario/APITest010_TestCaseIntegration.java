package com.thetestingacademy.RestAssuredBasics.IntegrationScenario;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest010_TestCaseIntegration {
    RequestSpecification r = RestAssured.given();
    Response res;
    ValidatableResponse vr;

    String token;
    String bookingId;

    public String getToken(){
        String payload = "{\n" +
                "\"username\" : \"admin\",\n" +
                "\"password\" : \"password123\"\n" +
                "}";
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON).log().all();
        r.body(payload);

        res = r.when().post();

        vr = res.then();
        vr.statusCode(200);

        token = res.jsonPath().getString("token");
        return token;
    }

    public String getBookingId(){
        String payload = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        //RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(payload);
        Response res = r.when().post();
        r.then().log().all().statusCode(200);
        bookingId = res.jsonPath().getString("bookingid");
        return bookingId;
    }

    @Test(priority = 1)
    public void test_update_request_put(){
        token = getToken();
        bookingId = getBookingId();
        System.out.println(token);
        System.out.println(bookingId);
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
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingId);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
//        r.auth().preemptive().basic("username","password123");
//        r.auth().oauth("vhdsf66334567");
        r.body(payload).log().all();

        res = r.when().put();

        vr = res.then().log().all();
        vr.statusCode(200);
    }

    @Test(priority = 2)
    public void test_verify_get_request(){
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingId);
        r.contentType(ContentType.JSON);

        res = r.when().get();

        vr = res.then().log().all();
        vr.statusCode(200);
        String firstName = res.jsonPath().getString("firstname");
        Assert.assertEquals(firstName,"James");
    }

    @Test(priority = 3)
    public void test_delete_request(){
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingId);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);

        r.when().delete();

        r.then().log().all().statusCode(201); // #TODO BUG

    }

    @Test(priority = 4)
    public void get_delete_booking_request(){
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingId);

        r.when().get();

        r.then().log().all().statusCode(404);

    }
}

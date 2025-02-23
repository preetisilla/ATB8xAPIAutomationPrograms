package com.thetestingacademy.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class APITest021_Assertions_RealEx {
    @Test
    public void test_POST() {
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
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(payload);
        Response res = r.when().post();
        ValidatableResponse vr = res.then().log().all();
        vr.statusCode(200);
        String bookingId = res.jsonPath().getString("bookingid");
        System.out.println(bookingId);

        //Validatable Response Assertion
        vr.body("booking.firstname", Matchers.equalTo("Jim"));
        vr.body("booking.lastname", Matchers.equalTo("Brown"));
        vr.body("bookingid", Matchers.equalTo(bookingId));
        vr.body("bookingid", Matchers.notNullValue());


        //TestNG Assert
        bookingId = res.then().extract().path("bookingId");
        String firstName = res.then().extract().path("booking.firstname");
        String lastName = res.then().extract().path("booking.lastname");

        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstName,"Jim");
        Assert.assertEquals(lastName,"Brown");

        //AssertJ - add dependency in Maven pom.xml file
        assertThat(bookingId).isNotNull().isNotBlank().isAlphanumeric();
        assertThat(firstName).isEqualTo("Jim").isNotNull().isNotBlank().isAlphanumeric();

    }
}


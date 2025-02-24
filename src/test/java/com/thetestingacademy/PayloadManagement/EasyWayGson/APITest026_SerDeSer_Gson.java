package com.thetestingacademy.PayloadManagement.EasyWayGson;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class APITest026_SerDeSer_Gson {
    @Test
    public void test_post_booking_request(){
        Booking booking = new Booking();
        booking.setFirstname("Jim");
        booking.setLastname("Brown");
        booking.setTotalprice(123);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2018-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(jsonStringBooking);

        Response res = r.when().post();
        String jsonResponseString = res.asString();

        r.then().log().all().statusCode(200);
        String bookingId = res.jsonPath().getString("bookingid");
        System.out.println(bookingId);

        //jsonPath(), extract() is used for simple json objects

        //for complex ones use gson deserialization
        BookingResponse br = gson.fromJson(jsonResponseString,BookingResponse.class);
        assertThat(br.getBookingid()).isNotZero().isNotNull();
        assertThat(br.getBooking().getFirstname()).isNotBlank().isEqualTo("Jim");


    }
}

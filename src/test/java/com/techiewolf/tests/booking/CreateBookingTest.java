package com.techiewolf.tests.booking;

import com.techiewolf.api.createbooking.Booking;
import com.techiewolf.api.createbooking.BookingApi;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateBookingTest {

  @Test
  void shouldCreateBookingSuccessfullyWithAllDetails() {
    // Arrange
    String createBookingSchema = "schemas/create-booking-schema.json";

    // Act
    Response createBooking = BookingApi.createBooking(Booking.getInstance());

    // Assert
    Assert.assertEquals(createBooking.statusCode(), 200);
    createBooking.then()
            .assertThat()
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(createBookingSchema));
    Assert.assertNotNull(createBooking.jsonPath().getString("booking.firstname"));
  }

}

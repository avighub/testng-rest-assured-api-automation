package com.techiewolf.tests.booking;

import com.techiewolf.api.createbooking.Booking;
import com.techiewolf.api.createbooking.BookingApi;
import com.techiewolf.assertion.VerifyResponse;
import com.techiewolf.setup.TestSetup;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

final class CreateBookingTest extends TestSetup {


  @Test
  void shouldCreateBookingSuccessfullyWithAllDetails() {
    // Arrange
    String createBookingSchema = "schemas/create-booking-schema.json";

    // Act
    Response createBooking = BookingApi.createBooking(Booking.getInstance());

    // Assert
    VerifyResponse.assertThat(createBooking)
            .matchStatusCode(200)
            .matchesSchema(createBookingSchema)
            .assertAll();
    VerifyCreateBookingResponse.assertThat(createBooking)
            .hasFirstname()
            .hasLastname()
            .assertAll();
  }

}

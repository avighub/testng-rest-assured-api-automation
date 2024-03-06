package com.techiewolf.tests.booking;

import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;

public final class VerifyCreateBookingResponse {
  private Response response;
  private SoftAssertions softAssertions;

  // Restricting to create instance of this class
  private VerifyCreateBookingResponse(Response response) {
    this.response = response;
    this.softAssertions = new SoftAssertions();
  }

  // Only possible entry point for the assertion class
  public static VerifyCreateBookingResponse assertThat(Response response) {
    return new VerifyCreateBookingResponse(response);
  }

  public VerifyCreateBookingResponse hasFirstname() {
    softAssertions
            .assertThat(response.getBody().jsonPath().getString("booking.firstname"))
            .isNotNull();
    return this;
  }

  public VerifyCreateBookingResponse hasLastname() {
    softAssertions
            .assertThat(response.getBody().jsonPath().getString("booking.lastname"))
            .isNotNull();
    return this;
  }

  public void assertAll() {
    softAssertions.assertAll();
  }
}

package com.techiewolf.api.createbooking;

import com.techiewolf.basespec.SpecFactory;
import com.techiewolf.config.properties.ConfigurationFactory;
import com.techiewolf.config.properties.EnvironmentConfig;
import com.techiewolf.utility.DateUtil;
import com.techiewolf.utility.FakerUtil;
import com.techiewolf.utility.JsonUtil;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;

@Slf4j
public final class BookingApi {

  private static final EnvironmentConfig ENV_CONFIG = ConfigurationFactory.getEnvironmentConfig();

  private BookingApi() {
  }

  public static Response createRandomBooking() {
    BookingDates bookingDates = BookingDates.builder()
            .setCheckin(DateUtil.getTodaysDateAsString("YYYY-mm-dd"))
            .setCheckout(DateUtil.getTodaysDateAsString("YYYY-mm-dd"))
            .build();
    Booking booking = Booking.builder()
            .setFirstname(FakerUtil.getRandomFirstName())
            .setLastname(FakerUtil.getRandomLastName())
            .setTotalprice(1000L)
            .setDepositpaid(true)
            .setAdditionalneeds("Breakfast")
            .setBookingdates(bookingDates)
            .build();

    return createBooking(booking);
  }

  public static Response createBooking(Booking booking) {
    log.debug("Request Body: {}", JsonUtil.printPojoToJson(booking));

    Response response = given()
            .spec(SpecFactory.getBaseSpec())
            .when()
            .body(booking)
            .post(ENV_CONFIG.createBooking())
            .then()
            .log()
            .ifError()
            .extract()
            .response();

    if (log.isDebugEnabled()) {
      response
              .then()
              .log().all();
    }
    return response;
  }
}

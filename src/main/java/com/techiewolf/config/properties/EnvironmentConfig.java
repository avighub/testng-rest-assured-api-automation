package com.techiewolf.config.properties;

import org.aeonbits.owner.Config;

/**
 * Owner library makes it painless to manage properties file configuration Refer documentation for
 * more.
 */
@Config.Sources({
  "file:src/main/resources/environment-config/${environment}.properties",
})
public interface EnvironmentConfig extends Config {

  /**
   * Everytime there is a new key added to Environment properties file ensure to add it here.
   * Similarly remove from here if there is a need.
   */
  @Key("baseUrl")
  String baseUrl();

  @Key("auth")
  String auth();

  @Key("get-booking")
  String getBooking();

  @Key("get-booking-by-id")
  String getBookingById();

  @Key("create-booking")
  String createBooking();

  @Key("update-booking")
  String updateBooking();
}

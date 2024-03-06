package com.techiewolf.api.auth;

import com.techiewolf.basespec.SpecFactory;
import com.techiewolf.config.properties.ConfigurationFactory;
import com.techiewolf.config.properties.EnvironmentConfig;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;

@Slf4j
public final class AuthApi {

  private static final EnvironmentConfig ENV_CONFIG = ConfigurationFactory.getEnvironmentConfig();

  private AuthApi() {
  }


  public static Response getToken(String username, String password) {
    Auth auth =
            Auth.builder()
                    .setUsername(username)
                    .setPassword(password)
                    .build();


    return given()
            .spec(SpecFactory.getBaseSpec())
            .when()
            .body(auth)
            .post(ENV_CONFIG.auth())
            .then()
            .log()
            .ifError()
            .extract()
            .response();
  }
}

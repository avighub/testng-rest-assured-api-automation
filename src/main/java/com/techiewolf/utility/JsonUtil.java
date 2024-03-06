package com.techiewolf.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class JsonUtil {

  private JsonUtil(){}

  @SneakyThrows
  public static String printPojoToJson(Object pojo){
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

    return objectMapper.writeValueAsString(pojo);
  }
}

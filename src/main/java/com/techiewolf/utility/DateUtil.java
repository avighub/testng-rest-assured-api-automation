package com.techiewolf.utility;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public final class DateUtil {

  private DateUtil() {
  }

  public static String getTodaysDateAsString(String format) {
    LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
    return now.format(formatter);
  }
}

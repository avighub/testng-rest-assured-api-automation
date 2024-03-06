package com.techiewolf.api.createbooking;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.techiewolf.utility.DateUtil;
import com.techiewolf.utility.FakerUtil;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder(setterPrefix = "set")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Accessors(chain = true)
public class Booking {
  private String firstname;
  private String lastname;
  private Long totalprice;
  private Boolean depositpaid;
  private BookingDates bookingdates;
  private String additionalneeds;

  public static Booking getInstance() {
    BookingDates bookingDates = BookingDates.builder()
            .setCheckin(DateUtil.getTodaysDateAsString("YYYY-mm-dd"))
            .setCheckout(DateUtil.getTodaysDateAsString("YYYY-mm-dd"))
            .build();
    return Booking.builder()
            .setFirstname(FakerUtil.getRandomFirstName())
            .setLastname(FakerUtil.getRandomLastName())
            .setTotalprice(1000L)
            .setDepositpaid(true)
            .setAdditionalneeds("Breakfast")
            .setBookingdates(bookingDates)
            .build();
  }
}

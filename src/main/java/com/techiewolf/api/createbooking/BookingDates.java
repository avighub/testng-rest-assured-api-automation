package com.techiewolf.api.createbooking;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder(setterPrefix = "set")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Accessors(chain = true)
public class BookingDates {
  private String checkin;
  private String checkout;
}

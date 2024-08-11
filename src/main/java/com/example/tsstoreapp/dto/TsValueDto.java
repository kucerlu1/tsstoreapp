package com.example.tsstoreapp.dto;

import java.time.ZonedDateTime;

public class TsValueDto {

  private ZonedDateTime timestamp;

  private Double value;

  public ZonedDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(ZonedDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }
}

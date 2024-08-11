package com.example.tsstoreapp.domain;

import java.time.Instant;
import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

@Measurement(name = "tsValue")
public class TsValue {

  @Column(name = "_time")
  private Instant time;

  @Column(name = "timeSeriesCode")
  private String timeSeriesCode;

  @Column(name = "value")
  private Double value;

  public Instant getTime() {
    return time;
  }

  public void setTime(Instant time) {
    this.time = time;
  }

  public String getTimeSeriesCode() {
    return timeSeriesCode;
  }

  public void setTimeSeriesCode(String timeSeriesCode) {
    this.timeSeriesCode = timeSeriesCode;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }
}

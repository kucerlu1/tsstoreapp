package com.example.tsstoreapp.domain;

public class TimeSeriesId {

  private String timeSeriesCode;

  public TimeSeriesId() {
  }

  public TimeSeriesId(String timeSeriesCode) {
    this.timeSeriesCode = timeSeriesCode;
  }

  public String getTimeSeriesCode() {
    return timeSeriesCode;
  }

  public void setTimeSeriesCode(String timeSeriesCode) {
    this.timeSeriesCode = timeSeriesCode;
  }
}

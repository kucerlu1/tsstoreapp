package com.example.tsstoreapp.dto;

import com.example.tsstoreapp.domain.TimeInterval;
import java.util.List;

public class ListTsDataDtoIn {

  private List<TimeSeriesDto> tsList;
  private TimeInterval timeInterval;

  public List<TimeSeriesDto> getTsList() {
    return tsList;
  }

  public void setTsList(List<TimeSeriesDto> tsList) {
    this.tsList = tsList;
  }

  public TimeInterval getTimeInterval() {
    return timeInterval;
  }

  public void setTimeInterval(TimeInterval timeInterval) {
    this.timeInterval = timeInterval;
  }
}

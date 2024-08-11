package com.example.tsstoreapp.dto;

import com.example.tsstoreapp.domain.TimeInterval;
import com.example.tsstoreapp.domain.TimeSeriesId;
import java.util.List;

public class TimeSeriesDto {

  private TimeSeriesId tsId;

  private List<TsValueDto> tsValueList;

  private TimeInterval timeInterval;

  public TimeSeriesId getTsId() {
    return tsId;
  }

  public void setTsId(TimeSeriesId tsId) {
    this.tsId = tsId;
  }


  public List<TsValueDto> getTsValueList() {
    return tsValueList;
  }

  public void setTsValueList(List<TsValueDto> tsValueList) {
    this.tsValueList = tsValueList;
  }

  public TimeInterval getTimeInterval() {
    return timeInterval;
  }

  public void setTimeInterval(TimeInterval timeInterval) {
    this.timeInterval = timeInterval;
  }
}

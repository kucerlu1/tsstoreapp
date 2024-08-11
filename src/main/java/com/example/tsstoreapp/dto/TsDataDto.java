package com.example.tsstoreapp.dto;

import java.util.List;

public class TsDataDto {

  private List<TimeSeriesDto> tsList;

  public List<TimeSeriesDto> getTsList() {
    return tsList;
  }

  public void setTsList(List<TimeSeriesDto> tsList) {
    this.tsList = tsList;
  }
}

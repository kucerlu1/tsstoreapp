package com.example.tsstoreapp.dto;

import java.util.List;

public class UpdateTsDataDtoOut {

  private final List<TimeSeriesDto> tsList;

  public UpdateTsDataDtoOut(List<TimeSeriesDto> tsList) {
    this.tsList = tsList;
  }

  public List<TimeSeriesDto> getTsList() {
    return tsList;
  }
}

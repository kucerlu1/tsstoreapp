package com.example.tsstoreapp.dto;

import com.example.tsstoreapp.domain.TsValue;
import java.util.List;

public class ListTsDataDtoOut {

  private final List<TsValue> tsValueList;

  public ListTsDataDtoOut(List<TsValue> tsValueList) {
    this.tsValueList = tsValueList;
  }

  public List<TsValue> getTsValueList() {
    return tsValueList;
  }
}

package com.example.tsstoreapp.controller;

import com.example.tsstoreapp.dto.DeleteTsDataDtoIn;
import com.example.tsstoreapp.dto.ListTsDataDtoIn;
import com.example.tsstoreapp.dto.ListTsDataDtoOut;
import com.example.tsstoreapp.dto.UpdateTsDataDtoIn;
import com.example.tsstoreapp.dto.UpdateTsDataDtoOut;
import com.example.tsstoreapp.model.TsDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uu-tsstore-maing01")
public class TsDataController {

  @Autowired
  private TsDataModel tsDataModel;

  @PostMapping(value = "/tsStore/tsData/update")
  @ResponseBody
  public UpdateTsDataDtoOut update(@RequestBody UpdateTsDataDtoIn dtoIn) {
    return tsDataModel.update(dtoIn);
  }

  @PostMapping(value = "/tsStore/tsData/list")
  @ResponseBody
  public ListTsDataDtoOut list(@RequestBody ListTsDataDtoIn dtoIn) {
    return tsDataModel.list(dtoIn);
  }

  @PostMapping(value = "/tsStore/tsData/delete")
  public void delete(@RequestBody DeleteTsDataDtoIn dtoIn) {
    tsDataModel.delete(dtoIn);
  }

  @PostMapping(value = "/tsStore/tsData/dropMeasurements")
  public void dropMeasurements() {
    tsDataModel.dropMeasurements();
  }
}

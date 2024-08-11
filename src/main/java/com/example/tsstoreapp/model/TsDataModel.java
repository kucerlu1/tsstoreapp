package com.example.tsstoreapp.model;

import com.example.tsstoreapp.dao.TsValueDao;
import com.example.tsstoreapp.domain.TimeInterval;
import com.example.tsstoreapp.domain.TsValue;
import com.example.tsstoreapp.dto.DeleteTsDataDtoIn;
import com.example.tsstoreapp.dto.ListTsDataDtoIn;
import com.example.tsstoreapp.dto.ListTsDataDtoOut;
import com.example.tsstoreapp.dto.TimeSeriesDto;
import com.example.tsstoreapp.dto.UpdateTsDataDtoIn;
import com.example.tsstoreapp.dto.UpdateTsDataDtoOut;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TsDataModel {

  @Autowired
  private TsValueDao tsValueDao;

  public UpdateTsDataDtoOut update(UpdateTsDataDtoIn dtoIn) {
    List<Point> tsValuePoints = dtoIn.getTsList().stream()
        .flatMap(this::mapTsValues)
        .toList();
    tsValueDao.write(tsValuePoints);
    return new UpdateTsDataDtoOut(dtoIn.getTsList());
  }


  private Stream<Point> mapTsValues(TimeSeriesDto timeSeriesDto) {
    String timeSeriesCode = timeSeriesDto.getTsId().getTimeSeriesCode();
    return timeSeriesDto.getTsValueList().stream()
        .map(tsValueDto -> Point.measurement("tsValue")
            .time(tsValueDto.getTimestamp().toInstant().getEpochSecond(), WritePrecision.S)
            .addTag("timeSeriesCode", timeSeriesCode)
            .addField("value", tsValueDto.getValue())
        );
  }

  public ListTsDataDtoOut list(ListTsDataDtoIn dtoIn) {
    List<String> timeSeriesCodes = dtoIn.getTsList().stream()
        .map(ts -> ts.getTsId().getTimeSeriesCode())
        .toList();
    return new ListTsDataDtoOut(tsValueDao.listByTsCodesAndTimeRange(timeSeriesCodes, dtoIn.getTimeInterval(), TsValue.class));
  }

  public void delete(DeleteTsDataDtoIn dtoIn) {
    List<CompletableFuture<Void>> futures = dtoIn.getTsList().stream()
        .map(ts -> deleteTsValueAsync(ts.getTimeInterval(), ts.getTsId().getTimeSeriesCode()))
        .toList();
    CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
  }

  private CompletableFuture<Void> deleteTsValueAsync(TimeInterval timeInterval, String tsId) {
    OffsetDateTime start = timeInterval.getFrom().toOffsetDateTime();
    OffsetDateTime stop = timeInterval.getTo().toOffsetDateTime();
    return CompletableFuture.runAsync(() -> tsValueDao.deleteTsValueByTsCodeAndTimeRange(tsId, start, stop));
  }

  public void dropMeasurements() {
    tsValueDao.dropMeasurements();
  }
}

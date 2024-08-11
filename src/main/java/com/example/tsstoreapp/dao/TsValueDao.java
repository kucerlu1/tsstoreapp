package com.example.tsstoreapp.dao;

import com.example.tsstoreapp.domain.TimeInterval;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.domain.DeletePredicateRequest;
import com.influxdb.client.write.Point;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TsValueDao {

  @Autowired
  private InfluxDBClient influxDBClient;
  @Value("${spring.influx.bucket}")
  private String bucket;
  @Value("${spring.influx.org}")
  private String org;

  public void write(List<Point> points) {
    influxDBClient.getWriteApiBlocking().writePoints(points);
  }

  public <M> List<M> listByTsCodesAndTimeRange(List<String> tsCodes, TimeInterval timeInterval, Class<M> targetClass) {
    String tsIdFilter = String.join("|", tsCodes);
    String query = String.format(
        "from(bucket: \"%s\") "
            + "|> range(start: %s, stop: %s) "
            + "|> filter(fn: (r) => r.timeSeriesCode =~ /^(%s)$/) "
            + "|> filter(fn: (r) => r._measurement == \"tsValue\")",
        bucket, timeInterval.getFrom().toInstant(), timeInterval.getTo().toInstant(), tsIdFilter
    );
    return influxDBClient.getQueryApi().query(query, targetClass);
  }

  public void deleteTsValueByTsCodeAndTimeRange(String tsId, OffsetDateTime start, OffsetDateTime stop) {
    DeletePredicateRequest predicateRequest = new DeletePredicateRequest()
        .predicate("_measurement = \"tsValue\" AND \"timeSeriesCode\" = \"" + tsId + "\"")
        .start(start)
        .stop(stop);
    influxDBClient.getDeleteApi().delete(predicateRequest, bucket, org);
  }

  public void dropMeasurements() {
    DeletePredicateRequest predicateRequest = new DeletePredicateRequest()
        .predicate("_measurement = \"tsValue\"")
        .start(OffsetDateTime.MIN.withYear(1970))
        .stop(OffsetDateTime.now());
    influxDBClient.getDeleteApi().delete(predicateRequest, bucket, org);
  }
}

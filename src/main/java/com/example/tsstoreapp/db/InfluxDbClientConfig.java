package com.example.tsstoreapp.db;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfluxDbClientConfig {

  @Value("${spring.influx.url}")
  private String influxDBUrl;

  @Value("${spring.influx.token}")
  private String token;

  @Value("${spring.influx.org}")
  private String org;

  @Value("${spring.influx.bucket}")
  private String bucket;

  @Bean
  public InfluxDBClient influxDB() {
    return InfluxDBClientFactory.create(influxDBUrl, token.toCharArray(), org, bucket);
  }
}

package com.example.tsstoreapp.domain;

import com.example.tsstoreapp.utils.TimeIntervalDeserializer;
import com.example.tsstoreapp.utils.TimeIntervalSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@JsonSerialize(using = TimeIntervalSerializer.class)
@JsonDeserialize(using = TimeIntervalDeserializer.class)
public class TimeInterval {

  private ZonedDateTime from;
  private ZonedDateTime to;

  public TimeInterval(ZonedDateTime from, ZonedDateTime to) {
    this.from = from;
    this.to = to;
  }

  public ZonedDateTime getFrom() {
    return from;
  }

  public void setFrom(ZonedDateTime from) {
    this.from = from;
  }

  public ZonedDateTime getTo() {
    return to;
  }

  public void setTo(ZonedDateTime to) {
    this.to = to;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimeInterval that = (TimeInterval) o;
    return Objects.equals(from, that.from) && Objects.equals(to, that.to);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to);
  }
}

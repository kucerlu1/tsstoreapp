package com.example.tsstoreapp.utils;

import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class DateTimeFormatter {

  public static final String PATTERN_TIME = "HH:mm";
  private static final String PATTERN_SHORT = "yyyy-MM-dd'T'HH:mm'Z'";
  private static final String PATTERN_LONG = "yyyy-MM-dd'T'HH:mm:ss'Z'";

  /**
   * Returns representation of ClockServiceProvider.UTC.now(UTC)).
   */
  public ZonedDateTime now() {
    return ClockServiceProvider.UTC.now();
  }

  /**
   * Returns string representation of ZonedDateTime.now(UTC)).
   */
  public String nowAsString() {
    return format(now());
  }

  /**
   * Format zoned date time (UTC) to string.
   */
  public String format(ZonedDateTime dateTime) {
    dateTime = toUtc(dateTime);
    return dateTime
        .format(java.time.format.DateTimeFormatter.ofPattern(PATTERN_SHORT));
  }

  /**
   * Format zoned date time (based on PATTERN_SHORT) to string.
   */
  public String format(ZonedDateTime dateTime, String pattern) {
    dateTime = toUtc(dateTime);
    if (pattern == null) {
      pattern = PATTERN_SHORT;
    }
    return ZonedDateTime.ofInstant(dateTime.toInstant(), ZoneOffset.UTC)
        .format(java.time.format.DateTimeFormatter.ofPattern(pattern));
  }

  /**
   * Format zoned date time (UTC) to string.
   */
  public String formatLong(ZonedDateTime dateTime) {
    dateTime = toUtc(dateTime);
    return dateTime
        .format(java.time.format.DateTimeFormatter.ofPattern(PATTERN_LONG));
  }

  public String formatTime(LocalTime time) {
    return time
        .format(java.time.format.DateTimeFormatter.ofPattern(PATTERN_TIME));
  }

  private ZonedDateTime toUtc(ZonedDateTime dateTime) {
    return dateTime.withZoneSameInstant(ZoneOffset.UTC);
  }
}

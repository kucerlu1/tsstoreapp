package com.example.tsstoreapp.utils;

import java.time.Clock;
import java.time.ZonedDateTime;

public enum ClockServiceProvider {
  DEFAULT(new ClockService(Clock.systemDefaultZone())),
  UTC(new ClockService());

  private final ClockService clockService;

  ClockServiceProvider(ClockService clockService) {
    this.clockService = clockService;
  }

  public ZonedDateTime now() {
    return this.clockService.now();
  }
}

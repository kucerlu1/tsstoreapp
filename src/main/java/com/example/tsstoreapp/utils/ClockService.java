package com.example.tsstoreapp.utils;

import java.time.Clock;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import org.springframework.stereotype.Component;

/**
 * Service provides clock.
 */
@Component
public class ClockService {

  private final Clock clock;

  public ClockService() {
    this.clock = Clock.systemUTC();
  }

  public ClockService(Clock clock) {
    this.clock = clock;
  }

  /**
   * Provides now date time.
   *
   * @return {@link ZonedDateTime}
   */
  public ZonedDateTime now() {
    return ZonedDateTime.now(clock)
        .truncatedTo(ChronoUnit.MILLIS);
  }

  public Clock getClock() {
    return clock;
  }

}

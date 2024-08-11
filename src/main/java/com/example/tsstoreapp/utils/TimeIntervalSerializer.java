package com.example.tsstoreapp.utils;

import com.example.tsstoreapp.domain.TimeInterval;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;

public class TimeIntervalSerializer extends StdSerializer<TimeInterval> {

  private final transient DateTimeFormatter dateTimeFormatter;

  public TimeIntervalSerializer() {
    this(null);
  }

  public TimeIntervalSerializer(Class<TimeInterval> t) {
    super(t);
    dateTimeFormatter = new DateTimeFormatter();
  }

  @Override
  public void serialize(TimeInterval value, JsonGenerator gen, SerializerProvider provider) throws IOException {
    if (containsNullValue(value)) {
      gen.writeString("null");
    } else {
      gen.writeStartObject();
      gen.writeStringField("from", dateTimeFormatter.formatLong(value.getFrom()));
      gen.writeStringField("to", dateTimeFormatter.formatLong(value.getTo()));
      gen.writeEndObject();
    }
  }

  private boolean containsNullValue(TimeInterval timeInterval) {
    return (timeInterval == null || timeInterval.getFrom() == null || timeInterval.getTo() == null);
  }
}
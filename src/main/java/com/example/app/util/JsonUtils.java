package com.example.app.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class JsonUtils {

  public static final ObjectMapper mapper = new ObjectMapper();

  public static String serialize(final Object o) throws JsonProcessingException {
    return mapper.writeValueAsString(o);
  }

  public static <T> T deserialize(final String value, final Class<T> valueType) throws IOException {
    return mapper.readValue(value, valueType);
  }

}

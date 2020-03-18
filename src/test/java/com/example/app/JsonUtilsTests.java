package com.example.app;

import com.example.app.domain.Message;
import com.example.app.util.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class JsonUtilsTests {

  @Test
  public void serialize_returnsJsonString() throws JsonProcessingException {
    Message message = new Message();
    message.setDestination("Pepe");
    message.setBody("Testing");

    String serialized = JsonUtils.serialize(message);
    String expected = "{\"destination\":\"Pepe\",\"body\":\"Testing\"}";

    Assert.assertEquals(serialized, expected);
  }

  @Test
  public void deserialize_returnsValidObject() throws IOException {
    String serializedMessage = "{\"destination\":\"Pepe\",\"body\":\"Testing\"}";

    Message message = JsonUtils.deserialize(serializedMessage, Message.class);

    Assert.assertEquals(message.getDestination(), "Pepe");
    Assert.assertEquals(message.getBody(), "Testing");
  }

  @Test(expected = MismatchedInputException.class)
  public void deserializeInvalidClass_throwsException() throws IOException {
    String serializedMessage = "{\"destination\":\"Pepe\",\"body\":\"Testing\"}";

    JsonUtils.deserialize(serializedMessage, Long.class);
  }

}

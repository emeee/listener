package com.example.app.listener;

import com.example.app.domain.DequeueException;
import com.example.app.domain.Message;
import com.example.app.repository.MessageDbRepository;
import com.example.app.util.JsonUtils;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

  private MessageDbRepository repository;

  @Autowired
  public Listener(final MessageDbRepository repository) {
    this.repository = repository;
  }

  @JmsListener(destination = "${spring.activemq.queue}", containerFactory = "myFactory")
  public void receiveMessage(final String message) {
    try {
      System.out.println("Received message: " + message);
      Message m = JsonUtils.deserialize(message, Message.class);
      repository.save(m);
      System.out.println("Message saved in database");
    } catch (Exception e) {
      throw new DequeueException(e.getMessage());
    }
  }

}

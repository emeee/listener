package com.example.app.listener;

import com.example.app.domain.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

  @JmsListener(destination = "${spring.activemq.queue}", containerFactory = "myFactory")
  public void receiveMessage(Message message) {
    System.out.println("Received message: " + message);
    // Do something
  }

}

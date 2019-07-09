package com.example.app.listener;

import com.example.app.domain.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

  @JmsListener(destination = "destination", containerFactory = "myFactory")
  public void receiveMessage(Message message) {
    System.out.println("Received <" + message + ">");

    // Do something
  }

}

package com.example.app.producer;

import com.example.app.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

  @Autowired
  private JmsTemplate jmsTemplate;

  public void enqueue(Message m) {
    System.out.println("Sending a message");
    jmsTemplate.convertAndSend("${spring.activemq.queue}", m);
  }

}

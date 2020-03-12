package com.example.app.producer;

import com.example.app.domain.EnqueueException;
import com.example.app.domain.Message;
import com.example.app.util.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

  private JmsTemplate jmsTemplate;

  private String queue;

  @Autowired
  public Producer(final JmsTemplate jmsTemplate,
      @Value("${spring.activemq.queue}") final String queue) {
    this.jmsTemplate = jmsTemplate;
    this.queue = queue;
  }

  public void enqueue(Message message) {
    try {
      System.out.println("Sending a message...");
      jmsTemplate.convertAndSend(queue, JsonUtils.serialize(message));
    } catch (JsonProcessingException e) {
      throw new EnqueueException(e.getMessage());
    }
  }

}

package com.example.app.producer;

import com.example.app.domain.EnqueueException;
import com.example.app.domain.Message;
import com.example.app.repository.MessageDbRepository;
import com.example.app.util.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.activemq.ScheduledMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

  private final JmsTemplate jmsTemplate;

  private final String queue;

  @Autowired
  public Producer(final JmsTemplate jmsTemplate,
      @Value("${spring.activemq.queue}") final String queue) {
    this.jmsTemplate = jmsTemplate;
    this.queue = queue;
  }

  public void enqueue(final Message message) {
    try {
      System.out.println("Sending a message...");
      String messageString = JsonUtils.serialize(message);
      jmsTemplate.convertAndSend(queue, messageString,
          m -> {
            m.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, 5000);
            return m;
          });
    } catch (JsonProcessingException e) {
      throw new EnqueueException(e.getMessage());
    }
  }

}

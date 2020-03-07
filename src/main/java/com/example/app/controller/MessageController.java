package com.example.app.controller;

import com.example.app.domain.Message;
import com.example.app.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

  private Producer producer;

  @Autowired
  public MessageController(final Producer producer) {
    this.producer = producer;
  }

  /**
   * Puts a message in queue
   * @param message
   */
  @PostMapping("/message")
  public ResponseEntity enqueueMessage(@RequestBody final Message message) {
    producer.enqueue(message);
    return ResponseEntity.ok().build();
  }

}

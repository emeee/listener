package com.example.app.controller;

import com.example.app.domain.Message;
import com.example.app.producer.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

  private MessageService messageService;

  @Autowired
  public MessageController(final MessageService messageService) {
    this.messageService = messageService;
  }

  /**
   * Puts a message in queue
   * @param message
   */
  @PostMapping("/message")
  @ResponseStatus(code = HttpStatus.CREATED)
  public void enqueueMessage(@RequestBody final Message message) {
    messageService.enqueue(message);
  }

}

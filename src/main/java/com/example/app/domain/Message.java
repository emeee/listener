package com.example.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

  private String to;
  private String body;

  public String getTo() {
    return to;
  }

  public String getBody() {
    return body;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public void setBody(String body) {
    this.body = body;
  }

  @Override
  public String toString() {
    return String.format("Message{to=%s, body=%s}", getTo(), getBody());
  }

}

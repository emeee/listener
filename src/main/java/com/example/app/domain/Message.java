package com.example.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "messages")
public class Message {

  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @Column
  private String destination;

  @Column
  private String body;

  public long getId() {
    return id;
  }

  public String getDestination() {
    return destination;
  }

  public String getBody() {
    return body;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public void setBody(String body) {
    this.body = body;
  }

  @Override
  public String toString() {
    return String.format("Message{to=%s, body=%s}", getDestination(), getBody());
  }

}

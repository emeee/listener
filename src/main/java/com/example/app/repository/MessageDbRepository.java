package com.example.app.repository;

import com.example.app.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageDbRepository extends CrudRepository<Message, Long> {

}

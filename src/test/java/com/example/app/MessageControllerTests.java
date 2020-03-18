package com.example.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import com.example.app.controller.MessageController;
import com.example.app.producer.MessageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MessageController.class)
public class MessageControllerTests {

  @MockBean
  private MessageService messageService;

  @Autowired
  private MockMvc mvc;

  @Test
  public void enqueueMessage_created() throws Exception {
    String message = "{\"destination\":\"Pepe\",\"body\":\"Testing\"}";
    RequestBuilder req = post("/message")
        .contentType(MediaType.APPLICATION_JSON)
        .content(message);
    mvc.perform(req).andExpect(status().isCreated());
  }

}

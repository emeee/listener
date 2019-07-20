package com.example.app.config;

import javax.jms.ConnectionFactory;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class ActiveMQConfig {

  @Value("${spring.activemq.broker-url}")
  private String brokerUrl;

  @Value("${spring.activemq.user}")
  private String activemqUser;

  @Value("${spring.activemq.password}")
  private String activemqPass;

  @Bean
  public ConnectionFactory connectionFactory() {
    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
    connectionFactory.setBrokerURL(brokerUrl);
    connectionFactory.setUserName(activemqUser);
    connectionFactory.setPassword(activemqPass);
    return connectionFactory;
  }

  @Bean
  public DefaultJmsListenerContainerFactory myFactory() {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setConnectionFactory(cachingConnectionFactory());
    factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
    return factory;
  }

  @Bean
  public CachingConnectionFactory cachingConnectionFactory() {
    return new CachingConnectionFactory(connectionFactory());
  }

  @Bean
  public JmsTemplate jmsTemplate() {
    return new JmsTemplate(cachingConnectionFactory());
  }
}

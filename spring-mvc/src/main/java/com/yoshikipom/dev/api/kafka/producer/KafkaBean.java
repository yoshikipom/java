package com.yoshikipom.dev.api.kafka.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class KafkaBean {

  private final ObjectMapper objectMapper;
  private final KafkaTemplate<String, String> kafkaTemplate;

  public KafkaBean(ObjectMapper objectMapper,
      KafkaTemplate<String, String> kafkaTemplate) {
    this.objectMapper = objectMapper;
    this.kafkaTemplate = kafkaTemplate;
  }

  @Bean
  public NewTopic topic() {
    return TopicBuilder.name("test")
        .partitions(10)
        .replicas(1)
        .build();
  }

  @Bean
  public KafkaHandlerInterceptor kafkaHandlerInterceptor() {
    return new KafkaHandlerInterceptor(objectMapper, kafkaTemplate);
  }
}

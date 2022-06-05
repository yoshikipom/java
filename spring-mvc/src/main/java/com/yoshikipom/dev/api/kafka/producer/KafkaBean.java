package com.yoshikipom.dev.api.kafka.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaBean {
  @Bean
  public NewTopic topic() {
    return TopicBuilder.name("test")
        .partitions(10)
        .replicas(1)
        .build();
  }
}

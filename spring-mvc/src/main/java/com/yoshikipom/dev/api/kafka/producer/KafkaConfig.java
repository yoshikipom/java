package com.yoshikipom.dev.api.kafka.producer;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "myapp.client.kafka")
@Data
public class KafkaConfig {

  private boolean enable = false;
}

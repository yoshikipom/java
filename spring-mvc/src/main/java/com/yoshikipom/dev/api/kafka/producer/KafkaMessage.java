package com.yoshikipom.dev.api.kafka.producer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KafkaMessage {

  private String timestamp;
  private String requestMethod;
  private String requestPath;
  private int responseStatus;
}

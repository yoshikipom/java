package com.yoshikipom.dev.api.kafka.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class KafkaHandlerInterceptor implements HandlerInterceptor {

  public static final String KAFKA_TOPIC = "test";

  private final ObjectMapper objectMapper;
  private final KafkaTemplate<String, String> kafkaTemplate;

  public KafkaHandlerInterceptor(ObjectMapper objectMapper,
      KafkaTemplate<String, String> kafkaTemplate) {
    this.objectMapper = objectMapper;
    this.kafkaTemplate = kafkaTemplate;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      @NonNull Object handler, Exception ex) throws Exception {

    var message = KafkaMessage.builder()
        .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
        .requestMethod(request.getMethod())
        .requestPath(request.getServletPath())
        .responseStatus(response.getStatus())
        .build();

    var messageString = objectMapper.writeValueAsString(message);
//    log.info(messageString);
    kafkaTemplate.send(KAFKA_TOPIC, messageString);
  }
}

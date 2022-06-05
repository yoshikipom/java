package com.yoshikipom.dev.api.kafka.producer;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class KafkaWebMvcConfig implements WebMvcConfigurer {

  private final KafkaHandlerInterceptor kafkaHandlerInterceptor;
  private final KafkaConfig kafkaConfig;

  public KafkaWebMvcConfig(
      KafkaHandlerInterceptor kafkaHandlerInterceptor,
      KafkaConfig kafkaConfig) {
    this.kafkaHandlerInterceptor = kafkaHandlerInterceptor;
    this.kafkaConfig = kafkaConfig;
  }

  @Override
  public void addInterceptors(@NonNull InterceptorRegistry registry) {
    if (kafkaConfig.isEnable()) {
      registry.addInterceptor(kafkaHandlerInterceptor)
          .addPathPatterns("/kafka/**")
          .excludePathPatterns("/static/**");
    }
  }
}

package com.yoshikipom.dev.exporter;

import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBean {

  @Bean
  public MinioClient minioClient() {
    return MinioClient.builder()
        .endpoint("http://localhost:9050")
        .credentials("root", "miniopass")
        .build();
  }
}

package com.yoshikipom.dev.api.httpclient;

import java.time.Duration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpClientBean {

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder,
      HttpClientConfiguration httpClientConfiguration) {
    return restTemplateBuilder
        .rootUri(httpClientConfiguration.getBaseUrl())
        .setConnectTimeout(Duration.ofMillis(httpClientConfiguration.getConnectionTimeoutMillis()))
        .setReadTimeout(Duration.ofMillis(httpClientConfiguration.getReadTimeoutMillis()))
        .build();
  }
}

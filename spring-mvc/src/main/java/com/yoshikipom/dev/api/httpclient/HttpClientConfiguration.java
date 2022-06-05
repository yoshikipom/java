package com.yoshikipom.dev.api.httpclient;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "myapp.client.http")
@Data
public class HttpClientConfiguration {

  private String baseUrl;
  private Long connectionTimeoutMillis;
  private Long readTimeoutMillis;
}

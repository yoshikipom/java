package com.yoshikipom.dev.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "myapp.config-test")
@Component
public class ConfigTest {

  private String key;
  private String key2 = null;
  private String envTest;
  private String noenv;
  private boolean flag;
  private String env;
}

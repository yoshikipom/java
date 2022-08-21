package com.yoshikipom.dev.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ConfigApplicationTest {

  @Autowired
  private ConfigTest configTest;

  @Test
  public void test() {
    log.info(configTest.getEnv());
  }
}

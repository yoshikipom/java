package com.yoshikipom.dev.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ConfigApplication implements CommandLineRunner {

  @Autowired
  private ConfigTest configTest;

  public static void main(String[] args) {
    SpringApplication.run(ConfigApplication.class, args);
    System.exit(0);
  }

  @Override
  public void run(String... args) throws Exception {
    log.info(configTest.toString());
  }
}

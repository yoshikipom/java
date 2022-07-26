package com.yoshikipom.dev.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class CliApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(CliApplication.class, args);
    System.exit(0);
  }

  @Override
  public void run(String... args) throws Exception {
    log.info("arg size: {}", args.length);
    for (int i = 0; i < args.length; ++i) {
      log.info("args[{}]: {}", i, args[i]);
    }
  }
}

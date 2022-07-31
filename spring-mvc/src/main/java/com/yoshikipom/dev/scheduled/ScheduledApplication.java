package com.yoshikipom.dev.scheduled;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class ScheduledApplication {

  public static void main(String[] args) {
    SpringApplication.run(ScheduledApplication.class, args);
  }

  //  @Scheduled(cron = "0 * 9 * * ?")
  @Scheduled(fixedRate = 1000)
  public void receive() {
    log.info("run scheduled task: {}", LocalDateTime.now());
  }
}

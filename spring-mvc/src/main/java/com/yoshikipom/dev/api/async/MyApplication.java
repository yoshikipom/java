package com.yoshikipom.dev.api.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Slf4j
public class MyApplication implements CommandLineRunner {

  @Autowired
  private MyAsyncService myAsyncService;

  public static void main(String[] args) {

    SpringApplication.run(MyApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    log.info("start app");
    try {
      // max pool size:2, queue size:1
      myAsyncService.executeAsyncProcess(); // will be executed
      myAsyncService.executeAsyncProcess(); // will be executed on another thread
      myAsyncService.executeAsyncProcess(); // will be queued
      myAsyncService.executeAsyncProcess(); // will not be executed due to shortage of thread pool
    } catch (TaskRejectedException e) {
      log.warn(e.getMessage());
    }
    log.info("finish app");
  }
}

package com.yoshikipom.dev.api.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyAsyncService {

  @Async("myTask")
  public void executeAsyncProcess() {
    log.info("start async process");
    log.info("sleep 1s");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    log.info("finish async process");
  }
}

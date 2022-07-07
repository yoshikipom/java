package com.yoshikipom.dev.api.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class MyTaskExecutorBean {

  @Bean(name = "myTask")
  public TaskExecutor myTaskExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(1);
    executor.setQueueCapacity(1);
    executor.setMaxPoolSize(2);
    return executor;
  }
}

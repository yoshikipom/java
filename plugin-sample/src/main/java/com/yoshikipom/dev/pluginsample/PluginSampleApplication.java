package com.yoshikipom.dev.pluginsample;

import com.yoshikipom.dev.pluginsample.core.CoreExecutor;
import com.yoshikipom.dev.pluginsample.core.CoreExecutorInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
@ConfigurationPropertiesScan
public class PluginSampleApplication implements CommandLineRunner {

  private final CoreExecutor coreExecutor;

  public static void main(String[] args) {
    SpringApplication.run(PluginSampleApplication.class, args);
    System.exit(0);
  }

  @Override
  public void run(String... args) throws Exception {
    log.info("===== run app for 'groupA' =====");
    coreExecutor.execute(new CoreExecutorInput("groupA"));
    log.info("===== run app for 'groupB' =====");
    coreExecutor.execute(new CoreExecutorInput("groupB"));
    log.info("===== run app for 'groupC (no config)' =====");
    coreExecutor.execute(new CoreExecutorInput("groupC"));
  }
}

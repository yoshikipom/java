package com.yoshikipom.dev.exporter.component;

import java.io.File;
import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class MyFileFetcherImpl implements MyFileFetcher {

  @Override
  public File execute() {
    try {
      return new ClassPathResource("dump.rdb").getFile();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

package com.yoshikipom.dev.pluginsample.core;

import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class CoreExecutor {

  private final PluginExecutor pluginExecutor;

  public void execute(CoreExecutorInput coreExecutorInput) {
    // do something for core before plugins
    log.info("process before plugins is running");

    // execute plugins
    pluginExecutor.execute(coreExecutorInput.pluginGroupName());

    // do something for core after plugins
    log.info("process after plugins is running");
  }
}

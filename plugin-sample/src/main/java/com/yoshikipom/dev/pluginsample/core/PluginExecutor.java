package com.yoshikipom.dev.pluginsample.core;

import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class PluginExecutor {

  private final PluginConfig pluginConfig;
  private final Map<String, Plugin> pluginMap;

  public void execute(String pluginGroupName) {
    // load config
    List<String> pluginExecutorNames = pluginConfig.pluginMap()
        .getOrDefault(pluginGroupName, null);

    // if no plugin config, return
    if (pluginExecutorNames == null) {
      return;
    }

    // execute plugins one by one
    for (var pluginExecutorName : pluginExecutorNames) {
      Plugin plugin = pluginMap.get(pluginExecutorName);
      PluginInput pluginExecutorInput = new PluginInput(); // you can add any input to this class
      PluginOutput pluginOutput = plugin.execute(pluginExecutorInput);
      // consume pluginOutput if necessary
    }
  }
}

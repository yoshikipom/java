package com.yoshikipom.dev.pluginsample.plugin;

import com.yoshikipom.dev.pluginsample.core.Plugin;
import com.yoshikipom.dev.pluginsample.core.PluginInput;
import com.yoshikipom.dev.pluginsample.core.PluginOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("barPlugin")
@Slf4j
public class BarPlugin implements Plugin {

  @Override
  public PluginOutput execute(PluginInput pluginInput) {
    log.info("BarPlugin is running!");
    return new PluginOutput();
  }
}

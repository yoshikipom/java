package com.yoshikipom.dev.pluginsample.core;

import java.util.List;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "myapp.plugin")
@ConstructorBinding
public record PluginConfig(Map<String, List<String>> pluginMap) {
}

package com.yoshikipom.dev.exporter.component;

import com.yoshikipom.dev.exporter.data.MyData;
import net.whitbeck.rdbparser.KeyValuePair;

public interface MyConverter {

  MyData execute(KeyValuePair keyValuePair);
}

package com.yoshikipom.dev.exporter.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yoshikipom.dev.exporter.data.MyData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import net.whitbeck.rdbparser.KeyValuePair;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyConverterImpl implements MyConverter {

  private final static String DATA_KEY = "field1";

  private final ObjectMapper objectMapper;

  @Override
  public MyData execute(KeyValuePair keyValuePair) {
    try {
      var keyOrValueList = keyValuePair.getValues();
      List<String> keys = new ArrayList<>();
      List<String> values = new ArrayList<>();
      for (int i = 0; i < keyOrValueList.size(); i++) {
        if (i % 2 == 0) {
          keys.add(new String(keyOrValueList.get(i), "ASCII"));
        } else {
          values.add(new String(keyOrValueList.get(i), "ASCII"));
        }
      }
      Map<String, String> map = new HashMap<>();
      for (int i = 0; i < keys.size(); i++) {
        map.put(keys.get(i), values.get(i));
      }

      return objectMapper.readValue(map.get(DATA_KEY), MyData.class);
    } catch (Exception exception) {
      throw new RuntimeException(exception);
    }
  }
}

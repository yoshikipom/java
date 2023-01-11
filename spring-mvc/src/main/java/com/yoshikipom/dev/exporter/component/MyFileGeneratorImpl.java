package com.yoshikipom.dev.exporter.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yoshikipom.dev.exporter.data.MyData;
import java.io.File;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyFileGeneratorImpl implements MyFileGenerator {

  private final ObjectMapper objectMapper;

  @Override
  public File execute(List<MyData> myDataList) {
    try {
      File file = new File("result.json");
      objectMapper.writeValue(file, myDataList);
      return file;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

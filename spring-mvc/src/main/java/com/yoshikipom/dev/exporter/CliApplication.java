package com.yoshikipom.dev.exporter;

import com.yoshikipom.dev.exporter.component.MyConverter;
import com.yoshikipom.dev.exporter.component.MyExporter;
import com.yoshikipom.dev.exporter.component.MyFileFetcher;
import com.yoshikipom.dev.exporter.component.MyFileGenerator;
import java.io.File;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.CollectionUtils;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class CliApplication implements CommandLineRunner {

  private final MyFileFetcher myFileFetcher;
  private final MyConverter myConverter;
  private final MyFileGenerator myFileGenerator;
  private final MyExporter myExporter;

  public static void main(String[] args) {
    SpringApplication.run(CliApplication.class, args);
    System.exit(0);
  }

  @Override
  public void run(String... args) throws Exception {
    log.info("fetch file");
    File inputFile = myFileFetcher.execute();
    try (var myDataReader = new MyDataReader(inputFile)) {
      while (true) {
        log.info("read data");
        var redisKeyValueList = myDataReader.readBatch();
        if (CollectionUtils.isEmpty(redisKeyValueList)) {
          break;
        }
        log.info("convert data");
        var myDataList = redisKeyValueList.stream().map(myConverter::execute)
            .collect(Collectors.toList());
        log.info("generate file");
        var file = myFileGenerator.execute(myDataList);
        log.info("send file");
        myExporter.execute(file);
      }
    }
    log.info("done");
  }
}

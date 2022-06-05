package com.yoshikipom.dev.api.kafka.producer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class KafkaController {

  @GetMapping("")
  public KafkaResponse get() {
    return new KafkaResponse("value");
  }

}

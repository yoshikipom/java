package com.yoshikipom.dev.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  @GetMapping("/")
  public MyResponse get() {
    return new MyResponse("value");
  }

}

package com.yoshikipom.dev.api.httpclient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PersonApiClient {

  private final RestTemplate restTemplate;

  public PersonApiClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public PersonResponse fetchList() {
    var response = restTemplate.getForEntity("http://localhost:9000/persons", PersonResponse.class);
    return response.getBody();
  }
}

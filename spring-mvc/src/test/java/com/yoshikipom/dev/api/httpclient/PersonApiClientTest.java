package com.yoshikipom.dev.api.httpclient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class PersonApiClientTest {

  @Autowired
  private PersonApiClient target;

  @Autowired
  private RestTemplate restTemplate;

  @Test
  public void test() {
    MockRestServiceServer mockServer = MockRestServiceServer.bindTo(restTemplate).build();
    var responseBody = """
        {
          "id":123,
          "name":"mock-name"
        }
              """;
    mockServer.expect(requestTo("http://localhost:9000/persons"))
        .andRespond(withSuccess(responseBody, MediaType.APPLICATION_JSON));

    var actual = target.fetchList();

    assertEquals("mock-name", actual.name());
  }

}

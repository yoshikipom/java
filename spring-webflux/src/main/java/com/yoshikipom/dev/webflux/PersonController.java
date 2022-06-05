package com.yoshikipom.dev.webflux;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

// ref https://spring.pleiades.io/spring-framework/docs/current/reference/html/web-reactive.html#webflux-controller
@RestController
@RequestMapping("/persons")
class PersonController {

  @GetMapping("/{id}")
  public Mono<Person> getPerson(@PathVariable String id) {
    return Mono.just(new Person(id));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Void> add(@RequestBody Person person) {
    return Mono.empty();
  }
}

package com.yoshikipom.dev.api.rest;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("items")
public class ItemController {

  @GetMapping("")
  public List<Item> get() {
    return List.of(new Item("value"));
  }

  @PostMapping("")
  public Item post(@RequestBody Item item) {
    return item;
  }
}

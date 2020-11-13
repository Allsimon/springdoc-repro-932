package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {

  @GetMapping("foo")
  public String bar(@RequestParam("value") String value) {
    return "Hello " + value;
  }
}

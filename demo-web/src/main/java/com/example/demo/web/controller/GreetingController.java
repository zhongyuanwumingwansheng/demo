package com.example.demo.web.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.core.model.Greeting;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //@GetMapping("/greeting")
    @RequestMapping(value = "/greeting", method= RequestMethod.GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}

package com.atasoy.examplewithchatgpt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GreetingController {

    @Value("${server.port}")
    private String port;

    @GetMapping
    public String greeting() {
        return "Hello from port " + port;
    }
}

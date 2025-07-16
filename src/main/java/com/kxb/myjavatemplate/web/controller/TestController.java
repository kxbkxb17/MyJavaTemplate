package com.kxb.myjavatemplate.web.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/open-api/test")
public class TestController {

    @GetMapping("/hello-world")
    public String test() {
        return "hello world";
    }
}

package com.kxb.myjavatemplate.web.controller;
import ch.qos.logback.core.pattern.color.BlueCompositeConverter;
import com.kxb.myjavatemplate.web.feign.BlueFeignClient;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/open-api/test")
public class TestController {

    @Resource
    BlueFeignClient blueFeignClient;

    @GetMapping("/hello-world")
    public String test() {
        return "hello world";
    }

    @GetMapping("/feign/id")
    public String feignId(@RequestParam("id") String id) {
        return String.format("GET方法调用blueocean成功：%s", blueFeignClient.getTestId(id));
    }
}

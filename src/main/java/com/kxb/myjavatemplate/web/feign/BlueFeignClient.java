package com.kxb.myjavatemplate.web.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "blueocean", url = "http://localhost:40001")
public interface BlueFeignClient {

    @GetMapping("/open-api/test/id")
    String getTestId(@RequestParam("id") String id);
}

package com.demo.eureka.consumer.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-provider")
public interface DcService {

    @GetMapping("/dc")
    String dc();
}

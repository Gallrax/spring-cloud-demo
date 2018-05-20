package com.demo.eureka.consumer.feign.controller;

import com.demo.eureka.consumer.feign.service.DcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {

    @Autowired
    DcService dcService;

    @GetMapping("/dc")
    public String dc() {
        return dcService.dc();
    }
}

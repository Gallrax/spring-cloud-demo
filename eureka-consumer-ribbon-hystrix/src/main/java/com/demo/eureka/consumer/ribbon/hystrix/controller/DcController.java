package com.demo.eureka.consumer.ribbon.hystrix.controller;

import com.demo.eureka.consumer.ribbon.hystrix.service.DcService;
import org.springframework.beans.factory.annotation.Autowired;
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

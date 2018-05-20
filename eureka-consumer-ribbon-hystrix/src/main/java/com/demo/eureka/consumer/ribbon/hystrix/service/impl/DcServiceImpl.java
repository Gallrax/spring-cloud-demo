package com.demo.eureka.consumer.ribbon.hystrix.service.impl;

import com.demo.eureka.consumer.ribbon.hystrix.service.DcService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DcServiceImpl implements DcService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    @Override
    public String dc() {
        try {
//            sleep 5s触发hystrix
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return restTemplate.getForObject("http://eureka-provider/dc", String.class);
    }

    public String fallback() {
        return "fallback";
    }

}

package com.xx.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/hello")
@RestController
public class HelloApi {

    @Autowired
    private RestTemplate restTemplate;

    //ribbon调用  spring.applicantion.name实例名+路径
    private final static String url = "http://eureka-client/eureka-client/hello/hello";

    @GetMapping("/hello")
    public String hello(){
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url,String.class);
        return responseEntity.getBody();
    }
}

package com.xx.cloud.controller;


import com.xx.cloud.config.ServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloApi {

    @Autowired
    private ServerConfig serverConfig;

    @GetMapping("/hello")
    public String hello(){
        return serverConfig.getServerPort()+":hello";
    }
}

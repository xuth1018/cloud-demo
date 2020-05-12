package com.xx.cloud.controller;


import com.xx.cloud.config.ServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
@RefreshScope
public class HelloApi {

    @Autowired
    private ServerConfig serverConfig;

    @Value("${cloud.site}")
    private String site;
    @GetMapping("/hello")
    public String hello(){
        System.out.println(site);
        return serverConfig.getServerPort()+":hello";
    }
}

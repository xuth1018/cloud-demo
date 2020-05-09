package com.xx.cloud.controller;

import com.xx.cloud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/customer")
@RestController
public class CustomerApi {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/dc")
    public String customer(){
        return customerService.customer();
    }
}

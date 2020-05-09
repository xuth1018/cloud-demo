package com.xx.cloud.service;

import com.xx.cloud.fallback.CustomerServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-client" ,fallback = CustomerServiceFallBack.class)
public interface CustomerService {

    @GetMapping("/eureka-client/hello/hello")
    String customer();
}

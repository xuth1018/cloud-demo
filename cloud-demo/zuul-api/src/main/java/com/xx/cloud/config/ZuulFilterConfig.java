package com.xx.cloud.config;

import com.xx.cloud.filter.ZuulDemoFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulFilterConfig {

    @Bean
    public ZuulDemoFilter zuulDemoFilter(){
        return new ZuulDemoFilter();
    }
}

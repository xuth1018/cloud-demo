package com.xx.cloud.fallback;

import com.xx.cloud.service.CustomerService;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceFallBack implements CustomerService {

    @Override
    public String customer() {
        return "service busy,please wait for minutes";
    }
}

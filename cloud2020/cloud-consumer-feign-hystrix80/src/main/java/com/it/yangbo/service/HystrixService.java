package com.it.yangbo.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;



@Component
@FeignClient(value = "cloud-provider-hystrix-payment", fallback = HystrixFallBackService.class)
public interface HystrixService {

    @RequestMapping("/hystrix/payment")
    public String getMessage();
    @RequestMapping("/hystrix/payment/timeout")
    public String getTimeOutMessage();
}

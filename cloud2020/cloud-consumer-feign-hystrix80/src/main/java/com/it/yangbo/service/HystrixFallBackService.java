package com.it.yangbo.service;

import org.springframework.stereotype.Component;

@Component
public class HystrixFallBackService implements HystrixService {
    @Override
    public String getMessage() {
        return "HystrixFallBackService --getMessage --fallback ";
    }

    @Override
    public String getTimeOutMessage() {
        return "HystrixFallBackService --getTimeOutMessage --fallback";
    }
}

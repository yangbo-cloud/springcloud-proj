package com.it.yangbo.controller;

import cloud.common.entity.CommonResult;
import cloud.common.entity.Payment;
import com.it.yangbo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @RequestMapping("/feign/find/{id}")
    public CommonResult<Payment> getMessage(@PathVariable("id") int id) {
        log.info("feign 做 服务调用  方法 ");


        return paymentService.getMessage(id);

    }

    @RequestMapping("/feign/timeout")
    public String timeOutMessage(){
        log.info("调用timeout方法");
        return paymentService.timeOutMessage();
    }
}

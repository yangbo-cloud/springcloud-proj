package com.it.yangbo.controller;


import com.it.yangbo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {



    @Resource
    private PaymentService paymentService;

    @RequestMapping("/hystrix/payment")
    public String getMessage(){
        return paymentService.getMessage();
    };

    @RequestMapping("/hystrix/payment/timeout")
    public String getTimeOutMessage(){
        return paymentService.getTimeOutMessage();
    };

    @RequestMapping("/hystrix/rongduan/{id}")
    public  String rongduanController(@PathVariable("id") int id){

        log.info("开始调用熔断方法rongduanController()，参数信息为 id :"+id);
        return paymentService.rongduan(id);
    }
}

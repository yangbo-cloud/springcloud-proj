package com.it.yangbo.controller;


import com.it.yangbo.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j


//配置全局的降级的方法  配置 @HystrixCommand  中的  fallbackmethod  的  降级走指定的方法   ，其他没有配置的，
// 出现异常情况  则直接走  默认的 DefaultProperties  配置的 defaultFallBack 方法



//解耦合   通过 feign 中的  fallback 属性    添加新的  fallback  配置类 实现  服务调用接口   完成  解耦合的服务降级
@DefaultProperties(defaultFallback = "globalHystrixMethod")
public class HystrixController {

    @Resource
    private HystrixService hystrixService;

    @RequestMapping("/hystrix/order")
    //@HystrixCommand
    public String getMessage(){
        //int a = 10/0;

        return hystrixService.getMessage();
    }


    //@HystrixCommand(fallbackMethod = "fallBackMsg")
        @HystrixCommand(fallbackMethod = "fallBackMsg",commandProperties = {
            //设置这个线程的超时时间是3s，3s内是正常的业务逻辑，超过3s调用fallbackMethod指定的方法进行处理
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
    @RequestMapping("/hystrix/order/timeout")
    public String getTimeOutMessage(){
        int a =10/0;

        return hystrixService.getTimeOutMessage();
    }

    public String fallBackMsg(){
        return "80客户端调用异常  fallbackMethod()";
    }
    
    
    /** 
    * @Description: defaule global hystrix  error method   默认的全局降级方法
    * @Param:  
    * @return:  
    * @Author: yangbo
    * @Date: 2020/4/9 9:59 上午
    */

    public String globalHystrixMethod()
    {
        return "global method  调用方法异常 请稍后再试";
    }


}

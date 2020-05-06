package com.it.yangbo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SentinelController {

    @RequestMapping("/sentinel/A")
    public String  testA(){
//        try {
//            Thread.sleep(800);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        log.info(Thread.currentThread().getName()+"/sentinel/A");
        return  "test SentinelA";
    }



    @RequestMapping("/sentinel/B")
    public String  testB(){

        return  "test SentinelB";
    }


    @RequestMapping("/sentinel/C")
    @SentinelResource(value = "sentinelC",blockHandler = "errorMethod")
    public String  testC(){

        return  "调用方法 testC";
    }
    public String errorMethod(BlockException b){
        return "调用方法异常";
    }

    @RequestMapping("/sentinel/D")
    @SentinelResource(value = "sentinelD")
    public String  testD(){
        return  "调用方法 testD";
    }






}

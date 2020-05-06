package com.it.yangbo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RefreshScope  //动态刷新
public class NacosConfigController {

    @Value("${config.info}")
    private String config_info;

    @RequestMapping("/nacos/config")
    public String  getMessage(){
        return config_info;
    }

}

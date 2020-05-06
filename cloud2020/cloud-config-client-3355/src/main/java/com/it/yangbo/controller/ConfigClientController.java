package com.it.yangbo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
//刷新功能  同步github上的信息
//然后在终端做一下同步刷新 curl -X POST "http://localhost:3355/actuator/refresh"
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String config_msg;

    @Value("${server.port}")
    private String server_port;

    @RequestMapping("/config")
    public String getMsg() {

        log.info("调用ConfigClient3355的getMsg方法");
        return "调用ConfigClient3355的getMsg方法,端口号为：" + server_port + ".yml文件的信息为：" + config_msg;
    }
}

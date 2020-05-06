package com.it.yangbo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
//分布式为服务 多台服务器指向同一个 config-server ，当 git配置信息修改时，不需要每一台做一次 刷新
// 直接 应用 bus+rabbitmq  刷新 config-server 即可同步刷新所有服务器
//然后在终端做一下同步刷新 curl -X POST "http://localhost:3355/actuator/refresh"
//然后在终端做一下同步刷新 curl -X POST "http://localhost:3344/actuator/bus-refresh"

//想要指定 服务器 刷新
//现在3344是可以直接拿到新数据，3355/3366不能，我们来发一条这样的Post请求
//        curl -X POST "http://localhost:3344/actuator/bus-refresh/config-client:3355"
//        config-client就是3355的微服务名，3355即端口号
@RefreshScope
public class ConfigController3366 {
    @Value("${config.info}")
    private String config_msg;

    @Value("${server.port}")
    private String server_port;

    @RequestMapping("/config")
    public String getMsg() {

        log.info("调用ConfigClient3366的getMsg方法");
        return "调用ConfigClient3366的getMsg方法,端口号为：" + server_port + ".yml文件的信息为：" + config_msg;
    }
}

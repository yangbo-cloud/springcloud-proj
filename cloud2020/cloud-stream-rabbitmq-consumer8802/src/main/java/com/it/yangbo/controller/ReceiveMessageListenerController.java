package com.it.yangbo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@Slf4j
//引入获取通道信息
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {


    @Value("${server.port}")
    private String server_port;

    @StreamListener(Sink.INPUT) //监听通道信息
    public void getMessage(Message<String> message){
        String payload = message.getPayload();
        log.info("一号消费者获取到的信息为："+payload+"  ，端口号为 port"+server_port);

    }
}

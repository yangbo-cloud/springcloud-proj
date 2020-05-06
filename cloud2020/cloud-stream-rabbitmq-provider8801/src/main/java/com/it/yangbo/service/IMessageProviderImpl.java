package com.it.yangbo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Name: IMessageProviderImpl
 * @Description: 消息发送实现类
 * @Author: yangbo
 * @Date: 2020/4/13 1:16 下午
 */
//这不是传统的service,这是和rabbitmq打交道的，不需要加注解@Service
//这里不掉dao，掉消息中间件的service
//信道channel和exchange绑定在一起  通道 + 交换机
@EnableBinding(Source.class)  //定义消息的推送通道  生产者  用户  Source.class   消费者用 Sink.class
@Slf4j
public class IMessageProviderImpl implements  IMessageProvider{

    //需要引入消息通道
    @Resource
    private MessageChannel output;
    @Override
    public String send() {
        String serialNo = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serialNo).build());
        log.info("*******生产者流水信息serialNo ：" + serialNo + "********");
        return "调用生产者流水信息成功" + serialNo;
    }
}

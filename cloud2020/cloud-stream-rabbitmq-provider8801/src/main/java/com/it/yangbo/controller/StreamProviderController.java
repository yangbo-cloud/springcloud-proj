package com.it.yangbo.controller;
import com.it.yangbo.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@Slf4j
public class StreamProviderController {

    @Resource
    private IMessageProvider iMessageProvider;


    @RequestMapping("/sendMessage")
    public String sendMessage(){
     return iMessageProvider.send();
    }
}


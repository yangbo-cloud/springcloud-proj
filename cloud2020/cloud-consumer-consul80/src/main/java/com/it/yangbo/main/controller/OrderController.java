package com.it.yangbo.main.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j


/**@Name: OrderController
 * @Description:   consul-order 测试
 * @Author: yangbo
 * @Date: 2020/4/5 5:03 下午
 */

public class OrderController {

    private static final String INVOKEPATH = "http://consul-provider-peyment";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consul/order")
    public String getMessageByConsul() {
        String forObject = restTemplate.getForObject(INVOKEPATH + "/consul/payment", String.class);
        return forObject;
    }
}

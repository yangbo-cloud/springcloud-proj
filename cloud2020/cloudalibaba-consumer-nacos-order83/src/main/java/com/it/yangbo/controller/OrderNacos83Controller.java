package com.it.yangbo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j


/**@Name: OrderNacos83Controller
 * @Description:
 * @Author: yangbo
 * @Date: 2020/4/14 4:50 下午
 */

public class OrderNacos83Controller {

    @Value("${service-url.nacos-user-service}")
    private String server_url;

    @Value("${server.port}")
    private String server_port;

    @Resource
    private RestTemplate restTemplate;


    @RequestMapping("/order/nacos/{id}")
    public String orderNacos(@PathVariable("id") int id) {
        String result = restTemplate.getForObject(server_url+"/payment/nacos/"+id, String.class);
        return "调用nacos order  成功   server_url:" + server_url + ",   " +
                "server_port:" + server_port + "返回的信息为 :" + result + id;
    }
}

package com.it.yangbo;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

//可以在服务端做降级  也可以在客户端做降级
//客户端的服务降级
//     yml文件中添加  开启 hystrix
//   通过标签    @EnableHystrix  激活
//   在controller层  添加 @HystrixCommand  标签  配置  fallbackMethod 属性
@EnableHystrix
public class Hystrix80App {
    public static void main(String[] args) {
        SpringApplication.run(Hystrix80App.class);
    }
}

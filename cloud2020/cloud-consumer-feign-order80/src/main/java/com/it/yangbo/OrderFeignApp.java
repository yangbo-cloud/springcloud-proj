package com.it.yangbo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//激活feign
@EnableFeignClients
public class OrderFeignApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignApp.class);
    }
}

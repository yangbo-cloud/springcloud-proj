package com.it.yangbo.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsul80App {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsul80App.class);
    }
}

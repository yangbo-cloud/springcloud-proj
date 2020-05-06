package com.it.yangbo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
public class SentinelService8401App {
    public static void main(String[] args) {
        SpringApplication.run(SentinelService8401App.class, args);
    }
}

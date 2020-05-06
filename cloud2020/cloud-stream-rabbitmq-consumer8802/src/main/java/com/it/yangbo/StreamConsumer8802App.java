package com.it.yangbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StreamConsumer8802App {
    public static void main(String[] args) {
        SpringApplication.run(StreamConsumer8802App.class, args);
    }
}

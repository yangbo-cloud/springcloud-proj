package com.it.yangbo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StreamProvider8801App {

    public static void main(String[] args) {
        SpringApplication.run(StreamProvider8801App.class,args);
    }
}

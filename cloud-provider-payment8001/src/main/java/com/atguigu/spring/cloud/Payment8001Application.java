package com.atguigu.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Payment8001Application {
// 這個是9001
    public static void main(String[] args) {
        SpringApplication.run(Payment8001Application.class,args);
    }
}

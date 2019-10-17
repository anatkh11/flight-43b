package com.haina.flight;

import com.netflix.discovery.EurekaNamespace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients("com.haina.flight")
@SpringBootApplication
public class Apiapplication {

    public static void main(String[] args) {
            SpringApplication.run(Apiapplication.class);
    }
}

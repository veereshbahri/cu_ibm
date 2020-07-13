package com.example.pixobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PixoBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(PixoBackEndApplication.class, args);
    }

}

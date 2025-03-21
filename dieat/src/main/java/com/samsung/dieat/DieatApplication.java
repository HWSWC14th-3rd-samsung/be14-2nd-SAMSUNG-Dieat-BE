package com.samsung.dieat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DieatApplication {

    public static void main(String[] args) {
        SpringApplication.run(DieatApplication.class, args);
    }

}

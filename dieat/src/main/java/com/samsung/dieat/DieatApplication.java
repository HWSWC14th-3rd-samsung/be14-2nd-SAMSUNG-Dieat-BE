package com.samsung.dieat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaAuditing
public class DieatApplication {

    public static void main(String[] args) {
        SpringApplication.run(DieatApplication.class, args);
        System.out.println("현재 인코딩: " + System.getProperty("file.encoding")); // UTF-8이어야 함

    }





}

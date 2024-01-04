package com.lwx.aPiDriver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-06  15:15
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class ApiDriverApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiDriverApplication.class);
    }
}

package com.lwx.apiBoss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-04  10:36
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ApiBossApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiBossApplication.class);
    }
}

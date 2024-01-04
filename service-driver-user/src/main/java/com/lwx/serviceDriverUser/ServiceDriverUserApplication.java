package com.lwx.serviceDriverUser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-09-27  14:44
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@MapperScan("com.lwx.serviceDriverUser.mapper")
public class ServiceDriverUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDriverUserApplication.class);
    }
}

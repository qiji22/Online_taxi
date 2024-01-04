package com.lwx.servicePassengerUser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-08-03  15:51
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.lwx.servicePassengerUser.mapper")
public class SerivcePassengerUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(SerivcePassengerUserApplication.class);
    }
}

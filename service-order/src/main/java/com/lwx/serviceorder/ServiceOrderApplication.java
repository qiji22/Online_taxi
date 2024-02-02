package com.lwx.serviceorder;

import javafx.application.Application;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-27  14:07
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.lwx.serviceorder.mapper")
public class ServiceOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceOrderApplication.class);
    }
}

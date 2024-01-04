package com.lwx.servicemap;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-08-03  15:51
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.lwx.servicemap.mapper")
public class ServiceMapApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceMapApplication.class);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

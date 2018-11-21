package com.cyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: CYH
 * @date: 2018/11/21 0021 20:02
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientEurekaRabbitMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientEurekaRabbitMqApplication.class, args);
    }

}

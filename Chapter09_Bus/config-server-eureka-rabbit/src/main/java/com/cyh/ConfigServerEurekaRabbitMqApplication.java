package com.cyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author: CYH
 * @date: 2018/11/21 0021 19:56
 */
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class ConfigServerEurekaRabbitMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerEurekaRabbitMqApplication.class, args);
    }

}

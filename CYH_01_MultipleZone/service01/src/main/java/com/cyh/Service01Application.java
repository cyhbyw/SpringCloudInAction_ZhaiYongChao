package com.cyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: yanhua.chen
 * @date: 2018/12/6 10:49
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Service01Application {

    public static void main(String[] args) {
        SpringApplication.run(Service01Application.class, args);
    }

}

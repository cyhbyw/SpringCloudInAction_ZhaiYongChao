package com.cyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: yanhua.chen
 * @date: 2018/11/14 9:42
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EnhancedHelloServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(EnhancedHelloServiceApplication.class, args);
    }


}

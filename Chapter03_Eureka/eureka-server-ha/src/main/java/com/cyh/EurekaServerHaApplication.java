package com.cyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: yanhua.chen
 * @date: 2018/11/13 16:46
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerHaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerHaApplication.class, args);
    }

}

package com.cyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: yanhua.chen
 * @date: 2018/12/6 10:44
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerZone01Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerZone01Application.class, args);
    }

}

package com.cyh;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: CYH
 * @date: 2018/11/21 0021 7:56
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientEurekaApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigClientEurekaApplication.class).web(true).run(args);
    }

}

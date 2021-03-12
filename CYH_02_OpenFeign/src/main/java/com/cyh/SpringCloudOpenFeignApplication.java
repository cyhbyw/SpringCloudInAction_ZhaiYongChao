package com.cyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: yanhua.chen
 * @date: 2021/3/11 16:42
 */
@EnableFeignClients(basePackages = "com.cyh.feign")
@SpringBootApplication
public class SpringCloudOpenFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudOpenFeignApplication.class, args);
    }

}

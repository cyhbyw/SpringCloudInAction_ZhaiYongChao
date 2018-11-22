package com.cyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/**
 * @author: CYH
 * @date: 2018/11/22 0022 8:32
 */
@SpringBootApplication
@EnableZipkinStreamServer
public class ZipkinServerStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerStreamApplication.class, args);
    }

}

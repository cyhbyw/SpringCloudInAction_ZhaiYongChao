package com.cyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/**
 * @author: CYH
 * @date: 2018/11/23 0023 8:42
 */
@SpringBootApplication
@EnableZipkinStreamServer
public class ZipkinServerStreamMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerStreamMysqlApplication.class, args);
    }

}

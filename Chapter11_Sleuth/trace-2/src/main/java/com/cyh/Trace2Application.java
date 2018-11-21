package com.cyh;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: CYH
 * @date: 2018/11/22 0022 7:07
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@Slf4j
public class Trace2Application {

    public static void main(String[] args) {
        SpringApplication.run(Trace2Application.class, args);
    }

    @RequestMapping(value = "/trace-2", method = RequestMethod.GET)
    public String trace() {
        log.info("call trace-2");
        return "trace-2: " + new Date();
    }

}

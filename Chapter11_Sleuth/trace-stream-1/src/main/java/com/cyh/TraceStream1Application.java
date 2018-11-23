package com.cyh;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: CYH
 * @date: 2018/11/22 0022 7:02
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@Slf4j
public class TraceStream1Application {

    public static void main(String[] args) {
        SpringApplication.run(TraceStream1Application.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/trace-stream-1", method = RequestMethod.GET)
    public String trace() throws InterruptedException {
        log.info("call trace-stream-1");
        TimeUnit.MILLISECONDS.sleep(200);
        return restTemplate().getForEntity("http://trace-stream-2/trace-stream-2", String.class).getBody();
    }

}

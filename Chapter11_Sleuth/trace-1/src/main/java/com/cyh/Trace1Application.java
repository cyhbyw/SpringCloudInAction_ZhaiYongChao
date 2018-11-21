package com.cyh;

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
public class Trace1Application {

    public static void main(String[] args) {
        SpringApplication.run(Trace1Application.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/trace-1", method = RequestMethod.GET)
    public String trace() {
        log.info("call trace-1");
        return restTemplate().getForEntity("http://trace-2/trace-2", String.class).getBody();
    }

}

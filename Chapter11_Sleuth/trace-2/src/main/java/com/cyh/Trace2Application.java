package com.cyh;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

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
    public String trace(HttpServletRequest request) {
        // 常量值来源: org.springframework.cloud.sleuth.Span
        log.info("call trace-2. TraceId={}, SpanId={}", request.getHeader("X-B3-TraceId"),
                request.getHeader("X-B3-SpanId"));
        return "trace-2: " + new Date();
    }

}

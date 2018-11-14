package com.cyh.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cyh.service.impl.HelloServiceFallback;

/**
 * @author: CYH
 * @date: 2018/11/14 0014 8:43
 */
@FeignClient(value = "hello-service", fallback = HelloServiceFallback.class)
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

}

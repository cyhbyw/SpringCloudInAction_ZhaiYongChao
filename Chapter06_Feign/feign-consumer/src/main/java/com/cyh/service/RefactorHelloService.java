package com.cyh.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.cyh.api.HelloServiceApi;

/**
 * @author: yanhua.chen
 * @date: 2018/11/14 10:09
 */
@FeignClient("enhanced-hello-service")
public interface RefactorHelloService extends HelloServiceApi {
}

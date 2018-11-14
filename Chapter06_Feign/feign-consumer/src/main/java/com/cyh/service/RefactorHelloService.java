package com.cyh.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.cyh.api.HelloServiceApi;
import com.cyh.service.impl.RefactorHelloServiceFallback;

/**
 * @author: yanhua.chen
 * @date: 2018/11/14 10:09
 */
@FeignClient(value = "enhanced-hello-service", fallback = RefactorHelloServiceFallback.class)
public interface RefactorHelloService extends HelloServiceApi {
}

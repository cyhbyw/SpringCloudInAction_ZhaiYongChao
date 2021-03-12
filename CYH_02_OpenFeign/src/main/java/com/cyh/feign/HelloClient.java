package com.cyh.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: yanhua.chen
 * @date: 2021/3/11 16:43
 */
@FeignClient(name = "hello-service")
public interface HelloClient {

    @GetMapping("/hello")
    String hello();

}

package com.cyh.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: yanhua.chen
 * @date: 2018/11/14 11:02
 */
@FeignClient("enhanced-hello-service")
public interface RibbonConfigHelloService {

    /**
     * Feign中Ribbon配置
     * 测试超时
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello();

}

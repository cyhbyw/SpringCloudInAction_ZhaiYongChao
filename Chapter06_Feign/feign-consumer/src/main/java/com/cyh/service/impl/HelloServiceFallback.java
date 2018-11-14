package com.cyh.service.impl;

import org.springframework.stereotype.Component;

import com.cyh.service.HelloService;

/**
 * @author: yanhua.chen
 * @date: 2018/11/14 14:38
 */
@Component
public class HelloServiceFallback implements HelloService {

    @Override
    public String hello() {
        return "error";
    }

}

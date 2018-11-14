package com.cyh.service.impl;

import org.springframework.stereotype.Component;

import com.cyh.domain.User;
import com.cyh.service.RefactorHelloService;

/**
 * @author: yanhua.chen
 * @date: 2018/11/14 14:59
 */
@Component
public class RefactorHelloServiceFallback implements RefactorHelloService {
    @Override
    public String hello(String name) {
        return "error";
    }

    @Override
    public User hello(String name, Integer age) {
        return new User("未知", -1);
    }

    @Override
    public String hello(User user) {
        return "error";
    }
}

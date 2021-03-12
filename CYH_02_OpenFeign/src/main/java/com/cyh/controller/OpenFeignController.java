package com.cyh.controller;

import com.cyh.feign.HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yanhua.chen
 * @date: 2021/3/11 16:50
 */
@RestController
public class OpenFeignController {

    @Autowired
    private HelloClient client;

    @RequestMapping("/test-hello")
    public String hello() {
        return client.hello();
    }

}

package com.cyh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yanhua.chen
 * @date: 2018/11/20 9:49
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${from}")
    private String from;
    @Autowired
    private Environment env;

    @RequestMapping("/from")
    public String from() {
        return this.from;
    }

    @RequestMapping("/fromFromEnv")
    public String fromFromEnv() {
        return env.getProperty("from", "undefined");
    }
}

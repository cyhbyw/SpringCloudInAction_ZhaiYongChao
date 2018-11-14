package com.cyh.web;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cyh.domain.User;

/**
 * @author: yanhua.chen
 * @date: 2018/11/14 10:00
 */
@RestController
public class SimpleHelloController {

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user) {
        return String.format("Hello %s, you are %d years old.", user.getName(), user.getAge());
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() throws InterruptedException {
        int sleepTime = 1000 * (1 + new Random().nextInt(5));
        System.err.println(new Date() + "  Will sleep: " + sleepTime);
        TimeUnit.MILLISECONDS.sleep(sleepTime);
        return "Hello World. Current time " + System.currentTimeMillis();
    }

}

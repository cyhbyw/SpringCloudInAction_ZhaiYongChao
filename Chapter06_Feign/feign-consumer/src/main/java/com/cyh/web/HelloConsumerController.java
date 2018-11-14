package com.cyh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cyh.domain.User;
import com.cyh.service.HelloService;
import com.cyh.service.RefactorHelloService;
import com.cyh.service.RibbonConfigHelloService;

/**
 * @author: CYH
 * @date: 2018/11/14 0014 8:44
 */
@RestController
public class HelloConsumerController {

    @Autowired
    private HelloService helloService;
    @Autowired
    private RefactorHelloService refactorHelloService;
    @Autowired
    private RibbonConfigHelloService ribbonConfigHelloService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer3", method = RequestMethod.GET)
    public String helloConsumer3() {
        StringBuilder builder = new StringBuilder();
        builder.append(refactorHelloService.hello("CYH")).append("\n");
        builder.append(refactorHelloService.hello("CYH", 28)).append("\n");
        builder.append(refactorHelloService.hello(new User("CYH", 28))).append("\n");
        return builder.toString();
    }

    @RequestMapping(value = "/config", method = RequestMethod.GET)
    public String ribbonConfigTest() {
        long start = System.currentTimeMillis();
        String s = ribbonConfigHelloService.hello();
        System.err.println("Cost time " + (System.currentTimeMillis() - start));
        return s;
    }
}

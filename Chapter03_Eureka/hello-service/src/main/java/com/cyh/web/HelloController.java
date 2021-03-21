package com.cyh.web;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yanhua.chen
 * @date: 2018/11/13 16:37
 */
@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        final List<String> services = client.getServices();
        for (String service : services) {
            List<ServiceInstance> instances = client.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println(String.format("host=%s, id=%s", instance.getHost(), instance.getInstanceId()));
            }
        }
        return "Hello World. Now time is: " + LocalDateTime.now();
    }

}

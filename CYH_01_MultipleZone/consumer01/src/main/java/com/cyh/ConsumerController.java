package com.cyh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: yanhua.chen
 * @date: 2018/12/6 10:55
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer")
    public String consumer() {
        return restTemplate.getForObject("http://service/hello", String.class);
    }

}

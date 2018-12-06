package com.cyh;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yanhua.chen
 * @date: 2018/12/6 10:52
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "zone02";
    }

}

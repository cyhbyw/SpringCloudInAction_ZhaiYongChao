package com.cyh.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cyh.domain.User;

/**
 * @author: yanhua.chen
 * @date: 2018/11/14 9:53
 */
@RequestMapping("/refactor")
public interface HelloServiceApi {

    @RequestMapping(value = "/hello4", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    /**
     * ***************  @RequestHeader("name") @RequestParam("name") 必须显示给出 value/name 否则会报错
     * ***************  而常规的 SpringMVC 中可以不给出 name/value
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/hello5", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello6", method = RequestMethod.POST)
    String hello(@RequestBody User user);

}

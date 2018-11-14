package com.cyh.service.impl;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cyh.api.HelloServiceApi;
import com.cyh.domain.User;

/**
 * @author: yanhua.chen
 * @date: 2018/11/14 9:43
 */
/**
 * 注意：这里需要使用 @RestController（本质是要使用 @Controller）注解，否则路径不会被 SpringMVC 映射
 */
@RestController
public class HelloServiceImpl implements HelloServiceApi {

    @Override
    public String hello(@RequestParam("name") String name) {
        return "Hello " + name;
    }

    /**
     * 虽然接口中已经使用 @RequestXXX 来标注参数，但是在实现类中仍然需要标注，否则数据全是null
     * 好像在高版本中，实现为中是不需要再冗余标注的
     * @param name
     * @param age
     * @return
     */
    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User(name, age);
    }

    /**
     * 虽然接口中已经使用 @RequestXXX 来标注参数，但是在实现类中仍然需要标注，否则数据全是null
     * 好像在高版本中，实现为中是不需要再冗余标注的
     * @param user
     * @return
     */
    @Override
    public String hello(@RequestBody User user) {
        return String.format("Hello %s, you are %d years old.", user.getName(), user.getAge());
    }
}

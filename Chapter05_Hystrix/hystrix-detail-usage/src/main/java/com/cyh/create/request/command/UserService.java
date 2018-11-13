package com.cyh.create.request.command;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.cyh.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;

/**
 * @author: CYH
 * @date: 2018/11/14 0014 7:34
 */
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 同步执行
     * @param id
     * @return
     */
    @HystrixCommand
    public User getUserById(Long id) {
        return restTemplate.getForObject("http://user-service/users{1}", User.class, id);
    }

    /**
     * 异步执行
     * @param id
     * @return
     */
    public Future<User> getUserByIdAsync(final String id) {
        return new AsyncResult<User>() {
            @Override
            public User invoke() {
                return restTemplate.getForObject("http://user-service/users{1}", User.class, id);
            }
        };
    }

}

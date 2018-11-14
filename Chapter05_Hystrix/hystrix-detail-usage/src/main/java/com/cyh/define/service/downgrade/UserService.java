package com.cyh.define.service.downgrade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.cyh.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author: CYH
 * @date: 2018/11/14 0014 7:57
 */
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultUser")
    public User getUserById(Long id) {
        return restTemplate.getForObject("http://user-service/users/{1}", User.class, id);
    }

    /**
     * 因为定义在同一个类中，所以对于访问权限没有要求（private protected public 都可以）
     * @return
     */
    @HystrixCommand(fallbackMethod = "defaultUserSecond")
    public User defaultUser() {
        // 如果这里不是简单地返回，而是执行其它逻辑（比如另一个网络请求），那么仍然有可能失败，于是，可以再次定义 fallbackMethod
        return new User();
    }

    private User defaultUserSecond() {
        return new User();
    }
}

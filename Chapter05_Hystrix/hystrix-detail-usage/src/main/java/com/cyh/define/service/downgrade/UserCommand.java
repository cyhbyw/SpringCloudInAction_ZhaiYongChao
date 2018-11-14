package com.cyh.define.service.downgrade;

import org.springframework.web.client.RestTemplate;

import com.cyh.domain.User;
import com.netflix.hystrix.HystrixCommand;

/**
 * @author: CYH
 * @date: 2018/11/14 0014 7:50
 */
public class UserCommand extends HystrixCommand<User> {

    private RestTemplate restTemplate;
    private Long id;

    public UserCommand(Setter setter, RestTemplate restTemplate, Long id) {
        super(setter);
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected User run() {
        return restTemplate.getForObject("http://user-service/users/{1}", User.class, id);
    }

    /**
     * 重载此方法来实现服务降级
     * Hystrix 在 run() 执行过程中出现错误、超时、线程池拒绝、断路器熔断等情况时会执行此方法
     *
     * 在 HystrixObservableCommand 实现的命令中，可能通过重载 resumeWithFallback() 方法来实现服务降级
     * @return
     */
    @Override
    protected User getFallback() {
        return new User();
    }
}

package com.cyh.create.request.command;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.web.client.RestTemplate;

import com.cyh.domain.User;
import com.netflix.hystrix.HystrixCommand;

import rx.Observable;

/**
 * HystrixCommand 返回的 Observable 只能发射一次数据
 * @author: CYH
 * @date: 2018/11/14 0014 7:27
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


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 同步执行
        User user = new UserCommand(null, new RestTemplate(), 1L).execute();

        // 异步执行
        Future<User> future = new UserCommand(null, new RestTemplate(), 1L).queue();
        future.get();

        // observe() 返回 Hot Observable
        Observable<User> hotObservable = new UserCommand(null, new RestTemplate(), 1L).observe();
        // toObservable() 返回 Cold Observable
        Observable<User> coldObservable = new UserCommand(null, new RestTemplate(), 1L).toObservable();
    }


}

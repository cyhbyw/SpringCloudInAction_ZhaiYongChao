package com.cyh.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: CYH
 * @date: 2018/11/21 0021 8:25
 */
@Component
@RabbitListener(queues = "hello")
public class Receiver {

    @RabbitHandler
    public void process(String msg) {
        System.err.println("接收者收到的消息 " + msg);
    }

}

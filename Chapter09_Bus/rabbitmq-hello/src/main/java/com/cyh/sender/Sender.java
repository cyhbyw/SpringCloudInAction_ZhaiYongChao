package com.cyh.sender;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: CYH
 * @date: 2018/11/21 0021 8:22
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String content = "Hello " + new Date();
        System.err.println("发送者发送的内容是 " + content);
        String routingKey = "hello";
        amqpTemplate.convertAndSend(routingKey, content);
    }

}

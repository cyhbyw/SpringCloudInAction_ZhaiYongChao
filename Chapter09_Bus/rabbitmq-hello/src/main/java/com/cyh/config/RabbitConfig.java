package com.cyh.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: CYH
 * @date: 2018/11/21 0021 8:26
 */
@Configuration
public class RabbitConfig {

    private static final String QUEUE_NAME = "hello";

    @Bean
    public Queue helloQueue() {
        return new Queue(QUEUE_NAME);
    }

}

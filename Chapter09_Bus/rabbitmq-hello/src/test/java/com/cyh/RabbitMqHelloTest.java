package com.cyh;

import com.cyh.sender.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: CYH
 * @date: 2018/11/21 0021 8:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RabbitMqHelloApplication.class)
public class RabbitMqHelloTest {

    @Autowired
    private Sender sender;

    @Test
    public void send() {
        sender.send();
    }

}

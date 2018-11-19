package com.cyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.cyh.error.attribute.MyErrorAttribute;
import com.cyh.processor.MyFilterProcessor;
import com.netflix.zuul.FilterProcessor;

/**
 * @author: yanhua.chen
 * @date: 2018/11/19 11:38
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulExceptionHandlerApplication {

    public static void main(String[] args) {
        FilterProcessor.setProcessor(new MyFilterProcessor());
        SpringApplication.run(ZuulExceptionHandlerApplication.class, args);
    }

    @Bean
    public DefaultErrorAttributes errorAttributes() {
        return new MyErrorAttribute();
    }

}

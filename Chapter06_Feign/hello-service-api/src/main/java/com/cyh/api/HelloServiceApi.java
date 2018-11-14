package com.cyh.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cyh.domain.User;

/**
 * @author: yanhua.chen
 * @date: 2018/11/14 9:53
 */
/**
 ********************* 这里不能写 @RequestMapping 注解 *******************************
 * 否则，在有 Fallback 实现类的情况下，SpringMVC 会报映射路径冲突
 * 大致原因如下：
 *   1. SpringMVC 会寻找所有的 Handler 并对它们进行路径映射
 *   2. RequestMappingHandlerMapping 类中的 isHandler() 方法实现如下
 *      return ((AnnotationUtils.findAnnotation(beanType, Controller.class) != null) ||
 * 				(AnnotationUtils.findAnnotation(beanType, RequestMapping.class) != null));
 * 		即，看类上是否有 @Controller 或者 @RequestMapping 注解，有就是 Handler
 *   3. 所以，如果在此处写了 @RequestMapping 注解，那么实现类及这个接口，都会进行路径映射，且路径相同，于是报错
 */
//@RequestMapping("/refactor")
public interface HelloServiceApi {

    @RequestMapping(value = "/hello4", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    /**
     * ***************  @RequestHeader("name") @RequestParam("name") 必须显示给出 value/name 否则会报错
     * ***************  而常规的 SpringMVC 中可以不给出 name/value
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/hello5", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello6", method = RequestMethod.POST)
    String hello(@RequestBody User user);

}

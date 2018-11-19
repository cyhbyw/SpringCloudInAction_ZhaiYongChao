package com.cyh.filter.post;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: yanhua.chen
 * @date: 2018/11/19 9:54
 */
@Component
@Slf4j
public class ThrowExceptionFilter extends ZuulFilter {
    @Override
    public String filterType() {
        // return "pre";
        return "post";
        // 开始是 pre 后面是 post
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 这部分内容需要随书中章节变化而对应变化：
     * 1. 开始的时候，filterType=pre
     *   刚开始，没有 ErrorFilter
     *      1.1. 没有 try catch 只有 doSomething() 方法，不能返回错误信息
     *      1.2. 加上 try catch，可以返回错误信息
     *   之后，加上了 ErrorFilter
     *      1.3. 不需要 try catch 因为 ErrorFilter 会统一处理，可以返回错误信息
     * 2. 后面的时候，filterType=post，且没有 try catch
     *      2.1. 没有实现针对 post 中异常的错误处理逻辑，所以仍然不能返回错误信息
     *      2.2. 有实现针对 post 中异常的错误处理逻辑，可以返回错误信息
     * @return
     */
    @Override
    public Object run() {
        log.info("This is a pre filter, it will throw a RuntimeException");
        doSomething();

        RequestContext context = RequestContext.getCurrentContext();
        try {
            //doSomething();
        } catch (Exception e) {
            context.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            context.set("error.exception", e);
        }
        return null;
    }

    private Object doSomething() {
        throw new RuntimeException("Exist some error...");
    }
}

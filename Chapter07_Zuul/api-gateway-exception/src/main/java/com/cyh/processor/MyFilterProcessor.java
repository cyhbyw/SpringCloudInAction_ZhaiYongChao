package com.cyh.processor;

import org.springframework.stereotype.Component;

import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author: yanhua.chen
 * @date: 2018/11/19 10:33
 */
@Component
public class MyFilterProcessor extends FilterProcessor {

    @Override
    public Object processZuulFilter(ZuulFilter filter) throws ZuulException {
        try {
            return super.processZuulFilter(filter);
        } catch (ZuulException e) {
            RequestContext context = RequestContext.getCurrentContext();
            context.set("failed.filter", filter);
            throw e;
        }
    }
}

package com.cyh.filter;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: CYH
 * @date: 2018/11/18 0018 10:41
 */
@Slf4j
public class AccessFilter extends ZuulFilter {

    /**
     * 过滤器类型，决定过滤器在请求的哪个生命周期中执行
     * pre 代表在请求被路由之前执行
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序，当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 该过滤器是否需要被执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体执行逻辑
     * @return
     */
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        log.info("Send '{}' request to '{}'", request.getMethod(), request.getRequestURL().toString());
        String accessToken = request.getParameter("accessToken");
        if (Objects.isNull(accessToken)) {
            log.warn("Access token is null");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            return null;
        }
        log.info("Access token is OK");
        return null;
    }
}

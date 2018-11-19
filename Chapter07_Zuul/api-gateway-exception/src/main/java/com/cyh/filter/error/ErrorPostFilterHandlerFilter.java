package com.cyh.filter.error;

import java.util.Objects;

import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 这是一个专门用来处理 PostFilter 中异常的 ErrorFilter
 * @author: yanhua.chen
 * @date: 2018/11/19 10:22
 */
@Component
public class ErrorPostFilterHandlerFilter extends SendErrorFilter {

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        // 大于 ErrorFilter 的值
        return 30;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        ZuulFilter failedFilter = (ZuulFilter) context.get("failed.filter");
        // 仅处理来自 Post 过滤器引起的异常
        return Objects.nonNull(failedFilter) && "post".equals(failedFilter.filterType());
    }


}

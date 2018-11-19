package com.cyh.error.attribute;

import java.util.Map;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.web.context.request.RequestAttributes;

/**
 * @author: yanhua.chen
 * @date: 2018/11/19 17:41
 */
public class MyErrorAttribute extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> result = super.getErrorAttributes(requestAttributes, includeStackTrace);
        // 删除了 exception 所以在最终呈现的异常信息中，将没有 exception 信息
        result.remove("exception");
        return result;
    }
}

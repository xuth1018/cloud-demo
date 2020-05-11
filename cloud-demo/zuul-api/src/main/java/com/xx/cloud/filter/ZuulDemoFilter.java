package com.xx.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

public class ZuulDemoFilter extends ZuulFilter {
    /**
     * pre:请求发送前执行过滤，
     * route：请求路由时
     * post：
     * error：出现错误
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {//数字越大 优先级越低
        return 0;
    }

    @Override
    public boolean shouldFilter() {//是否执行
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        //获取请求上下文
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        return null;
    }
}

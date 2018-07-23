package cn.sp.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ship
 * @Description Zuul过滤器打印日志
 * @Date: 2018-07-23 14:33
 */
public class PreRequestLogFilter extends ZuulFilter {

    private static final Logger log = LoggerFactory.getLogger(PreRequestLogFilter.class);


    @Override
    public String filterType() {
        //返回过滤器的类型，有pre,route,post,error等几种值
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("send %s request to %s",request.getMethod(),request.getRequestURL().toString()));
        return null;
    }
}

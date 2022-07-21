package com.example.smarthomecoreserviceintegration.rpc.Configuration;

import com.example.smarthomecommonutil.HttpUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author Yihan Chen
 * @date 2022/7/27 13:57
 */
@Configuration
public class FeignConfig implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        //获取到进入时的request对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (null != attributes) {
            HttpServletRequest request = attributes.getRequest();
            //获取到请求头名字
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                //获取到请求头
                String value = request.getHeader(name);
                //经过处理逻辑后
                //使用进入的request对象来设置Feign请求对象的请求头
                requestTemplate.header(name, value);
            }
            //获取进入线程的Cookie信息（获取token信息）
            String token = HttpUtil.getCookie(request, "userToken");
            //设置Cookie字段
            requestTemplate.header("Cookie", "userToken=" + token);
        }
    }
}

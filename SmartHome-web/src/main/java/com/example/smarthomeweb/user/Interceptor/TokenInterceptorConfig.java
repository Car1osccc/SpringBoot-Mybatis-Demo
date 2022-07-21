package com.example.smarthomeweb.user.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author Yihan Chen
 * @date 2022/7/27 16:05
 */
@Configuration
public class TokenInterceptorConfig implements WebMvcConfigurer {

    @Resource
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor).
                addPathPatterns("/**").excludePathPatterns("/v1/user/loginCheck");
    }
}

package com.fcc.springbootweb01.configuration;

import com.fcc.springbootweb01.util.MyIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class MyWebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyIntercepter())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/login")
                .excludePathPatterns("/css/**", "/fonts/**", "/images/**", "/js/**");
        System.out.println("拦截器");

    }
}
    


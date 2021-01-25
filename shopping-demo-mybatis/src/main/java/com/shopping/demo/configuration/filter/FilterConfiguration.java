package com.shopping.demo.configuration.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

//@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean registrationFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        // 设置过滤器
        filterRegistrationBean.setFilter(new MyFilter());
        // 指定url策略
        filterRegistrationBean.addUrlPatterns("/*");
        // 设置过滤器名称
        filterRegistrationBean.setName("myFilter");

        filterRegistrationBean.setOrder(-1);

        return filterRegistrationBean;
    }

}

package com.springboot.cms.config;

import com.springboot.cms.filter.Filter4;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<Filter4> registrationBean() {
        FilterRegistrationBean<Filter4> filter4FilterRegistrationBean = new FilterRegistrationBean<>();
        filter4FilterRegistrationBean.setFilter(new Filter4());
        filter4FilterRegistrationBean.addUrlPatterns("/customers/*");
        return filter4FilterRegistrationBean;
    }
}

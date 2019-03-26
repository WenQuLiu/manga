package com.baizhi.cmfz.cmfzadmin.util;

import com.baizhi.cmfz.cmfzadmin.util.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@SpringBootConfiguration
public class MySpringMvcConfig extends WebMvcConfigurerAdapter {
    /*@Autowired
    private UserConfig userConfigl;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userConfigl).addPathPatterns("/**");
    }*/
}

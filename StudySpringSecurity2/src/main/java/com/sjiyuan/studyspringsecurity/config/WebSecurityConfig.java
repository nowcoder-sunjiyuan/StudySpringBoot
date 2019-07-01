package com.sjiyuan.studyspringsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName WebSecurityConfig
 * @Description TODO
 * @Author sjy
 * @Date 2019/7/1 23:21
 * @Version 1.0
 **/
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 配置user-detail服务
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth)throws Exception{

    }

    /**
     * 拦截请求
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http)throws Exception{

    }

    /**
     * 拦截请求
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {

    }
}

package com.sjiyuan.studyspringsecurity.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sjiyuan.studyspringsecurity.domain.result.ResultMsg;
import com.sjiyuan.studyspringsecurity.filter.CustomAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;
import org.springframework.security.web.session.ConcurrentSessionFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.security.web.session.SimpleRedirectSessionInformationExpiredStrategy;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @ClassName WebSecurityConfig
 * @Description TODO
 * @Author sjy
 * @Date 2019/7/1 23:21
 * @Version 1.0
 **/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //authorizeRequests()启用基于HttpServletRequest的限制访问，启用之后就可以对某些路径进行访问权限控制了。
        http.authorizeRequests()
                //允许“/ha.html”进入，不需要认证
                .antMatchers("/ha.html").permitAll()
                .antMatchers("/admin/**").hasAuthority("admin")
                .antMatchers("/user/**").hasAuthority("operator")
                /*.antMatchers("/login").permitAll()*/
                //任何的请求均需要认证,无权会返回403
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> {
                    /**
                     * 自定义的没有登陆的操作，没权限的操作
                     */
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    response.setContentType("application/json;charset=UTF-8");
                    String jsonString = JSON.toJSONString(ResultMsg.UNLogin());
                    PrintWriter out = response.getWriter();
                    out.write(jsonString);
                    out.flush();
                    out.close();
                });
        /* and()*/
        /**
         * 指定支持基于表单的身份验证(formLogin())，指定登录的请求路径(loginPage('/login')),
         * successForwardUrl("/index.html"):表示认证成功后跳转页面
         * loginProcessingUrl()：表示登录时提交的地址，默认情况下，不应该是页面上表单的action起作用吗？？
         * permitAll表示/login.html可以访问，没有将会进入死循环。不停地login.html
         */
        /*.formLogin().loginPage("/login.html").permitAll();*/


                /*http.sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true).expiredSessionStrategy(event -> {
                    HttpServletResponse response = event.getResponse();
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    response.setContentType("application/json;charset=UTF-8");
                    String jsonString = JSON.toJSONString(ResultMsg.RepeatLogin());
                    PrintWriter out = response.getWriter();
                    out.write(jsonString);
                    out.flush();
                    out.close();
                });*/
        //将这个过滤器放在UsernamePasswordAuthenticationFilter的位置，UsernamePasswordAuthenticationFilter失效了
        http.addFilterAt(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }


    @Bean
    public CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();

        filter.setAuthenticationSuccessHandler((request, response, authentication) -> {
            response.setContentType("application/json;charset=utf-8");
            request.getSession().setMaxInactiveInterval(3600);
            PrintWriter out = response.getWriter();
            out.write(JSONObject.toJSONString(new ResultMsg("登录成功")));
            out.flush();
            out.close();
        });

        filter.setAuthenticationFailureHandler((request, response, exception) -> {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            /*Result<Object> result;
            if (exception instanceof UsernameNotFoundException) {
                result = ResultUtils.generateResult(4001, "用户名不存在");
            } else if (exception instanceof BadCredentialsException) {
                result = ResultUtils.generateResult(4001, "用户名或密码错误");
            } else if (exception instanceof DisabledException) {
                result = ResultUtils.generateResult(4001, exception.getMessage());
            } else if (exception instanceof AuthenticationServiceException) {
                result = ResultUtils.generateResult(4001, exception.getMessage());
            } else if (exception instanceof ValidateCodeException) {
                result = ResultUtils.generateResult(4001, exception.getMessage());
            } else {
                result = ResultUtils.generateResult(4001, "请刷新网页");
            }*/
            out.write(JSONObject.toJSONString(new ResultMsg("登录失败")));
            out.flush();
            out.close();
        });
        filter.setFilterProcessesUrl("/login");
        filter.setAuthenticationManager(authenticationManager());
        //filter.setSessionAuthenticationStrategy(createCompositeSession());
        return filter;
    }


}

package com.example.netdata.config;

import com.example.netdata.Handler.AccessHandler;
import com.example.netdata.Handler.FailureHandler;
import com.example.netdata.Handler.SuccessHandler;
import com.example.netdata.filter.CustomAuthenticationFilter;
import com.example.netdata.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName WebSecurityConfig
 * @Description TODO
 * @Author sjy
 * @Date 2019/6/26/026 17:55
 * @Version 1.0
 **/
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserService customUserService;
    @Autowired
    private AccessHandler accessHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * 配置自定义的UserDetailService,为了进行自定义认证
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService);
        super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasRole("operator")
                .antMatchers("/resources/**").permitAll()

                /**
                 * 通过调用authorizeRequests()和 anyRequest().authenticated()就会要求所有进入应用的
                 * HTTP请求都要进行认证。
                 */
                .anyRequest().authenticated()
                .and().csrf().disable()
                /**
                 * 访问任何路径都会返回/index.html,index.html中username，password请求路径为loginProcessingUrl参数/login
                 */
                .formLogin().loginPage("/login.html").loginProcessingUrl("/login").permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessHandler);

        //httpSecurity.addFilterAt(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        super.configure(httpSecurity);
    }

    /**
     * 这个过滤器是为了实现用json登录
     * @return
     * @throws Exception
     */
    @Bean
    CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(new SuccessHandler());
        filter.setAuthenticationFailureHandler(new FailureHandler());
        //Sets the URL that determines if authentication is required
        filter.setFilterProcessesUrl("/login");

        //这句很关键，重用WebSecurityConfigurerAdapter配置的AuthenticationManager，不然要自己组装AuthenticationManager
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.WebSecurity)
     */
    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/login.html","/blogimg/**", "/index.html", "/static/**", "/code/image",
                "/timeout","/css/**","/fonts/**","/img/**","/js/**");
    }
}


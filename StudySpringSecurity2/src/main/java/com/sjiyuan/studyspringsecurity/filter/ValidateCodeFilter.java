/*
package com.sjiyuan.studyspringsecurity.filter;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.druid.util.StringUtils;
import com.dic.application.domain.User;
import com.dic.application.exception.ValidateCodeException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

*/
/**
 * @ClassName ValidateCodeFilter
 * @Description TODO
 * @Author sjy
 * @Date 2019/7/4 17:26
 * @Version 1.0
 **//*

public class ValidateCodeFilter extends OncePerRequestFilter {
    private AuthenticationFailureHandler authenticationFailureHandler;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        if (StringUtils.equals("/login", request.getRequestURI()) && StringUtils.equalsIgnoreCase(request.getMethod(), "post")) {

            String line;
            StringBuffer jsonData = new StringBuffer();
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            while ((line = in.readLine()) != null) {
                jsonData.append(line);
            }
            User parse = (User)JSONUtils.parse(jsonData.toString());

            if(parse.getCode() != request.getSession().getAttribute("SESSION_KEY_IMAGE_CODE")){

                authenticationFailureHandler.onAuthenticationFailure(request, response, new ValidateCodeException("验证码不正确"));
                return;
            }
            */
/*try {
                // 1. 进行验证码的校验
                validate(new ServletWebRequest(httpServletRequest), httpServletRequest);
            } catch (ValidateCodeException e) {
                // 2. 如果校验不通过，调用SpringSecurity的校验失败处理器
                authenticationFailureHandler.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
                return;
            }*//*

        }
        // 3. 校验通过，就放行
        filterChain.doFilter(request, response);
    }
}
*/

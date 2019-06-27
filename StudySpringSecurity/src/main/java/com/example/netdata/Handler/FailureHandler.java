package com.example.netdata.Handler;

import com.example.netdata.util.Result;
import com.example.netdata.util.ResultUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName FailureHandler
 * @Description TODO  失败处理器
 * @Author sjy
 * @Date 2019/6/27/027 14:56
 * @Version 1.0
 **/
public class FailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        Result result = ResultUtils.getSuccessResult("登录失败");
        out.write(new ObjectMapper().writeValueAsString(result));
        out.flush();
        out.close();
    }
}

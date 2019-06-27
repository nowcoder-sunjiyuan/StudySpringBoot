package com.example.netdata.Handler;

import com.example.netdata.util.Result;
import com.example.netdata.util.ResultUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName SuccessHandler
 * @Description TODO 成功处理器
 * @Author sjy
 * @Date 2019/6/27/027 14:55
 * @Version 1.0
 **/
public class SuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        Result result = ResultUtils.getSuccessResult("登录成功");
        out.write(new ObjectMapper().writeValueAsString(result));
        out.flush();
        out.close();
    }
}

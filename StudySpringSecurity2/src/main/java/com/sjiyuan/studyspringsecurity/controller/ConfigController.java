package com.sjiyuan.studyspringsecurity.controller;

import com.sjiyuan.studyspringsecurity.domain.result.ResultMsg;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigController
 * @Description TODO
 * @Author sjy
 * @Date 2019/7/1 14:30
 * @Version 1.0
 **/
@RestController
public class ConfigController {

    @RequestMapping("/session/invalid")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ResultMsg sessionInvalid() {
        return ResultMsg.SessionFailure();
    }

    @RequestMapping("/timeout")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ResultMsg timeout() {
        return ResultMsg.RepeatLogin();
    }

}

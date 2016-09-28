package com.debug.controller.log;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by chenhao on 2016/9/14 0014.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login.do")
    public String login(HttpServletRequest request) {
        return "login/login";
    }
}

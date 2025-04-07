package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class TestController {

    @RequestMapping(value = "/", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String testStart(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        return "Проект живой! 🚀";
    }
}

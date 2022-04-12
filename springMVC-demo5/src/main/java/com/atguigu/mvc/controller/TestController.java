package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        return "success";
    }

    @RequestMapping("/testExpectionHandler")
    public String testExpectionHandler(){
        System.out.println(1/0);
        return "success";
    }
}

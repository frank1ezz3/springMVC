package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    //请求映射 非常重要
    @RequestMapping(value = "/")
    public String index(){
        //返回视图名称
        return "index";
    }

    @RequestMapping("/param")
    public String param(){
        return "test_param";
    }
}

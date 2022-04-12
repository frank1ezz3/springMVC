package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/testThyeleafView")
    public String testThyeleafView(){//没有前缀就是thymeleafView
        return "success";
    }

    @RequestMapping("/testForward")
    public String testForward(){//转发试图 创建IntetnalResourceView 转发过去之后就执行上面的thymeleafView
        //转发会保留之前的路径，但是重定向就和之前的路径没有关系了
        return "forward:/testThyeleafView";//只能转发到后一个html页面的请求（用的不多，但是重定向用的多）
    }

    @RequestMapping("/testRedirect")//重定向返回的是请求的页面，但是转发试图返回的是要copy的页面，显示的地址是RequestMaping的地址
    public String testRedirect(){
        return "redirect:/testThyeleafView";//web-inf下的页面不能被重定向（所以直接重定向一个请求）
    }

}

package com.atguigu.mvc.controller;

import com.atguigu.mvc.controller.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HttpController {

    @RequestMapping(value = "/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println("requestBody:"+requestBody);
        return "success";
    }

    @RequestMapping(value = "/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){
        //当前requestEntity表示整个请求保温的信息
        System.out.println("请求的："+requestEntity.getHeaders());
        System.out.println("请求的："+requestEntity.getBody());
        return "success";
    }

    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().println("hello response");
    }

    @RequestMapping(value = "/testResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "success";
    }

    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser(){
        return new User(1001,"admin","123456",23,"男");
    }

    //ajax是在页面不跳转的情况下与服务器进行交互
    @RequestMapping("/testAxios")
    @ResponseBody
    /**
     * @RestController注解是springMVC提供的一个复合注解，
     * 标识在控制器的类上，
     * 就相当于为类添加了@Controller注解，
     * 并且为其中的每个方法添加了@ResponseBody注解
     */
    public String testAxios(String username, String password){
        System.out.println("username:"+username+",password:"+password);
        return "hello,axios";
    }


}

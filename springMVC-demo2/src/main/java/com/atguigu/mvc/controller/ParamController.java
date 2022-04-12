package com.atguigu.mvc.controller;

import com.atguigu.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class ParamController {

    @RequestMapping("/testServletAPI")
    //形参位置的request表示当前请求
    public String testServletAPI(HttpServletRequest request){//这样就不能用restful的网站名方式了，很容易被nt搞
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username"+username+"password"+password);
        return "success";
    }

    @RequestMapping("/testParam")
    public String testParam(
            @RequestParam(value = "username" , required = false ,defaultValue = "名字都不写啊") String username, //false就是不输入username也不没事，true就是会报错且没设置DefaultValue
            String password,
            String[] hobby,
            @RequestHeader("Host")String host,
            @CookieValue("JSESSIONID") String JSESSION){//username:1,password:1,hobby:[a, b, c]
        //若请求参数中出现多个同名的请求参数，可以再控制器方法的形参位置设置字符串类型或字符串数组接收
        //若使用字符串类型测形参，最终结果为请求参数的每一个值之前使用都好进行拼接
        System.out.println("username:"+username+",password:"+password+",hobby:"+ Arrays.toString(hobby));
        System.out.println("host:"+host);
        System.out.println(JSESSION);//第一次进去会报错，因为第一次还在set—cokkie在request中没有cokkie的值
        return "success";
    }

    @RequestMapping("/testBean")
    public String testBean(User user){
        System.out.println(user);
        return "success";
    }










}

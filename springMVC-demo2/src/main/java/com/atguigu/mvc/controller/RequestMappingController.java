package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.handler.RequestMatchResult;
//我的理解requestMapping是筛选里面的东西
@Controller
//@RequestMapping(value = "/hello")
public class RequestMappingController {
    //不可以再写一个相同的@RequestMapping因为映射是唯一的 不然会有选择困难症会报错
//    @RequestMapping(value = "/")
//    public String index(){
//        //返回视图名称
//        return "target";
//    }
    @RequestMapping(
            value = {"testRequestMapping","/test"},
            method = {RequestMethod.GET,RequestMethod.POST}
//            params = {"username"}
    )
    public String success(){
        return "success";
    }

    @RequestMapping(value = "/testPut",method = RequestMethod.PUT)
    public String testPut(){

        return "success";
    }

    @RequestMapping(
            value = "/testParamsAndHeaders",
            params = {"username"},
            headers = {"Host=localhost:8080"}
    )
    public String testParamsAndHeaders(){
        return "success";
    }


    @RequestMapping("/a?a/testAnt")
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/testPath/{id}/{username}")
    public String testPath(@PathVariable("id")Integer id,@PathVariable("username") String username){
        System.out.println("id"+id+",username"+username);
        return "success";
    }

}

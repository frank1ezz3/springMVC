package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeController {
    //使用servletAPI向request域对象共享数据
    @RequestMapping("testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request){
        request.setAttribute("testRequestScope","BULL SHIT,ServletAPI");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        /**
         * ModelAndView有Model和View的功能
         * Model主要用于向请求域共享数据
         * View主要用于设置视图，实现页面跳转
         */
        ModelAndView mav = new ModelAndView();//这个得创建对象
        //处理模型数据，即向请求域request共享数据
        mav.addObject("testRequestScope","HOLY SHIT,ServletAPI");
        //设置视图名称
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testRequestScope","hello,model");
        System.out.println(model.getClass().getName());//都是 BindingAwareModelMap 类型
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        map.put("testRequestScope", "hello,Map1");
        System.out.println(map.getClass().getName());//都是 BindingAwareModelMap 类型
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope", "hello,ModelMap");
        System.out.println(modelMap.getClass().getName());//都是 BindingAwareModelMap 类型
        return "success";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session){//浏览器启动和关闭的范围 session最大未操作时间为30min
        session.setAttribute("testSessionScope", "hello,session");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){//整个工程的范围
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope", "hello,application");
        return "success";
    }
}

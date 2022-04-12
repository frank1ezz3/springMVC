package com.atguigu.mvc.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

//web工程的初始化类，用来代替web.xml
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 指定spring的配置类
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {//获取当前的根配置
        return new Class[]{SpringConfig.class};
    }

    /**
     * 指定springmvc的配置类
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {//设置springMVC的配置类
        return new Class[]{Webconfig.class};
    }

    /**
     * 指定DispatcherServlet的Url-pattern的路径
     * @return
     */
    @Override
    protected String[] getServletMappings() {//获取当前DispatcherServlet的映射路径，也就是url-partem
        return new String[]{"/"};
    }

    /**
     * （注册）添加过滤器
     * @return
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceRequestEncoding(true);
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        return new Filter[]{encodingFilter, hiddenHttpMethodFilter};
    }
}

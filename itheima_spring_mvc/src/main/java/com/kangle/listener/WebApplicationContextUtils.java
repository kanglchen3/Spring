package com.kangle.listener;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

public class WebApplicationContextUtils {
    public static ApplicationContext getWebApplicationContext(ServletContext sc){
        return (ApplicationContext) sc.getAttribute("app");
    }
}

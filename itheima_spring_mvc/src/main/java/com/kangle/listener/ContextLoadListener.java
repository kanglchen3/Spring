package com.kangle.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoadListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        //读取web.xml中的全局参数
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);
//        将spring的上下文对象存储到ServletContext域中

        servletContext.setAttribute("app", app);
        System.out.println("通过listener将spring容器创建完毕。。。");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

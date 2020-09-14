package com.kangle.web;

import com.kangle.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ServletContext servletContext = req.getServletContext();
        ServletContext servletContext = this.getServletContext();
//        去拿servlet context下的 app 这个attribute
//        ApplicationContext app = (ApplicationContext) servletContext.getAttribute("app");
//        通过utils 的静态方法去拿 app，避免"app"的耦合性
//        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);



//      spring-web提供的utils里面自带的监听器
        WebApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);


        UserService userService = app.getBean(UserService.class);
        userService.save();
    }
}

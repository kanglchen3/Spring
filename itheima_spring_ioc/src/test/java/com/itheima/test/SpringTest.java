package com.itheima.test;

import com.itheima.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    //scope
    public void test(){
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao1 = (UserDao) app.getBean("userDao");
//        userDao1.save();

        UserDao userDao2 = (UserDao) app.getBean("userDao");
//        userDao2.save();
//        userDao2=null;


        app.close();
//        System.out.println(userDao1);
//        System.out.println(userDao2);
    }
}

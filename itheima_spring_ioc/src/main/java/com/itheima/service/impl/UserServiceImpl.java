package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }

//set 方法注入依赖
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    public void save(){
        userDao.save();
    }

//    @Override
//    public void save() {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        UserDao userDao = (UserDao) app.getBean("userDao");
//        userDao.save();
//        System.out.println(userDao);
//    }
}

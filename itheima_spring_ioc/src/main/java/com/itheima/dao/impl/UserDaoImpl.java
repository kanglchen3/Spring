package com.itheima.dao.impl;

import com.itheima.dao.UserDao;

public class UserDaoImpl implements UserDao {
    public UserDaoImpl(){
        System.out.println("UserDaoImp创建...");
    }

    public void init(){
        System.out.println("初始化方法...");
    }

    public void destroy(){
        System.out.println("销毁方法...");
    }

    public void save(){
        System.out.println("save running...");
    }
}

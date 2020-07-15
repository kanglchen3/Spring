package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.springframework.stereotype.Repository;

//<bean id="userDao" class="com.itheima.dao.impl.UserDaoImpl"/>
@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {
    public void save(){
        System.out.println("save running...");
    }
}

package com.kangle.service.impl;

import com.kangle.dao.UserDao;
import com.kangle.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void save(){ userDao.save();}

}

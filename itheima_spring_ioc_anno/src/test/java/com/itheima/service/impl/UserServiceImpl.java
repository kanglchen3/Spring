package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//<bean id="userService" class="com.itheima.service.impl.UserServiceImpl">
//</bean>

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    //<property name="userDao" ref="userDao"></property>
//    @Autowired //按照数据类型 从spring容器中进行匹配的
//    @Qualifier("userDao")   //是按照id的值，名称从容器中进行匹配。但是此处要结合@Autowired一起使用
    @Resource(name="userDao")
    private UserDao userDao;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void save() {
        userDao.save();
    }
}

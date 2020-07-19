package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//<bean id="userService" class="com.itheima.service.impl.UserServiceImpl">
//</bean>

@Service(value = "userService")
//@Scope("prototype")
@Scope("singleton")
public class UserServiceImpl implements UserService {

    @Value("${jdbc.driver}") //可以用  $找配置文件里的值
    private String driver;
    //<property name="userDao" ref="userDao"></property>
    @Autowired //按照数据类型 从spring容器中进行匹配的
    @Qualifier("userDao")   //是按照id的值，名称从容器中进行匹配。但是此处要结合@Autowired一起使用
//    @Resource(name="userDao")   //resource相当于Autowired + qualifier
    private UserDao userDao;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void save() {
        System.out.println(driver);
        userDao.save();
    }

    @PostConstruct
    public void init(){
        System.out.println("Service 对象的初始化方法");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Service 对象的销毁方法");
    }
}

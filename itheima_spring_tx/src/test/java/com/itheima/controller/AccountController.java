package com.itheima.controller;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:applicationContext.xml")
public class AccountController {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//    private AccountService accountService;

    @Test
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = app.getBean(AccountService.class);
        accountService.transfer("tom", "lucy", 500);
    }
}

package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:applicationContext.xml")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void out(String outMan, double money){
        jdbcTemplate.update("update account set money=money-? where name=?", money, outMan);
    }

    @Override
    public void in(String inMan, double money){
        jdbcTemplate.update("update account set money=money+? where name=?", money, inMan);
    }
}

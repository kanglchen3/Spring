package com.itheima.test;

import com.itheima.domain.Account;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class jdbcTemplateCRUDTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
//    @Ignore
    public void testQueryCount(){
        Long aCount = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(aCount);
    }

    @Test
    @Ignore
    public void testQuerySingle(){
        Account jacky = jdbcTemplate.queryForObject("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), "Jacky");
        System.out.println(jacky);
    }

    @Test
    @Ignore
    public void testQueryAll(){
        List<Account> accountList = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);
    }

    @Test
    @Ignore
    public void testUpdate(){
        jdbcTemplate.update("update account set money=? where name=?", 1000, "tom");
    }

    @Test
    @Ignore
    public void testDelete(){
        jdbcTemplate.update("delete from account where name=?", "tom");
    }
}

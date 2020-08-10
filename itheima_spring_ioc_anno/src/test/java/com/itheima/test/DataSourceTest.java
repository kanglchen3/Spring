package com.itheima.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class DataSourceTest {
    @Test
    //测试spring容器创建 c3p0(使用加载配置文件形式)
    public void test5() throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = app.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    //测试手动创建 c3p0(使用加载配置文件形式)
    public void test4() throws Exception {
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        String driver = rb.getString("jdbc.driver");
        String url = rb.getString("jdbc.url");
        String username = rb.getString("jdbc.username");
        String password = rb.getString("jdbc.password");

        ComboPooledDataSource dataSource1 = new ComboPooledDataSource();
        dataSource1.setDriverClass(driver);
        dataSource1.setJdbcUrl(url);
        dataSource1.setUser(username);
        dataSource1.setPassword(password);


        Connection connection = dataSource1.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    //测试手动创建 druid
    public void test2() throws Exception {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        druidDataSource.setUrl("jdbc:mysql://localhost:3306/test");
//        druidDataSource.setUsername("root");
//        druidDataSource.setPassword("kangle");
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/test");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("kangle");
        DruidPooledConnection connection = druidDataSource.getConnection();
        System.out.println(connection);
        connection.close();

    }

    @Test
    //测试手动创建 c3p0
    public void test1() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("kangle");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    //手动建立连接
    public void test3() throws Exception {
        String driverName="com.mysql.cj.jdbc.Driver";//这是要连接的数据库加载器
        String dbURL="jdbc:mysql://localhost:3306/test";//这是要连接的端口号以及数据库名称
        String userName="root";//用户名
        String userpwd="root";//用户密码
        try {
            Class.forName(driverName);
            System.out.println("加载驱动成功");
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("加载驱动失败");
        }
        try {
//            Connection dbConn= DriverManager.getConnection(dbURL,userName,userpwd);
            Connection dbConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=kangle");
            System.out.println("连接数据库成功");
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
}

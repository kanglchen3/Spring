package com.itheima.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration  //b标志该类是Spring和核心配置类
@Import({DataSourceConfiguration.class})

//<context:component-scan base-package="com.itheima"/>
@ComponentScan("com.itheima")

public class SpringConfiguration {


}

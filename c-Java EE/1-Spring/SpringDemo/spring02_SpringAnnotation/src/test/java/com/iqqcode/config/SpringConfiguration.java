package com.iqqcode.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;

//标志该类是Spring的核心配置类
@Configuration


//配置组件扫描
//<context:component-scan base-package="com.iqqcode"/>
@ComponentScan("com.iqqcode")


//引入其他配置文件
//<import resource="applicationContext-user.xml"/>
@Import({DataSourceConfiguration.class})


public class SpringConfiguration {

}

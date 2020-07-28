package com.iqqcode.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;


//加载外部的properties文件
//<context:property-placeholder location="classpath:jdbc.properties"/>
@PropertySource("classpath:jdbc.properties")


public class DataSourceConfiguration {
    // 属性注入
    // 去Spring容器中寻找匹配的key,将key对应的value值赋给属性

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;


    // Spring会将当前方法的返回值-以指定名称存储到Spring容器中
    @Bean
    public DataSource getDataSource() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        //将参数放回到Spring中
        return dataSource;
    }
}

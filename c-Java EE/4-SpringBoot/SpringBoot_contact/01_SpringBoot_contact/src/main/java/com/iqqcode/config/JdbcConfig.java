package com.iqqcode.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-30 18:29
 * @Description:配置数据源信息
 */

@Configuration
public class JdbcConfig {

    @Bean
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource dataSource() {
        return new DruidDataSource();
    }
}

package com.iqqcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-30 17:15
 * @Description:SpringBoot工程都有一个启动引导类，这是工程的入口类
 */

@SpringBootApplication

//通用Mapper, 扫描mybatis所有的业务mapper接口
@MapperScan("com.iqqcode.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

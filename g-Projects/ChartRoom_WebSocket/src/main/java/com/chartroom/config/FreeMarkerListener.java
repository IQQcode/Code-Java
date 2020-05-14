package com.chartroom.config;
import	java.nio.charset.StandardCharsets;


import freemarker.template.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-12 09:25
 * @Description:
 */
@WebListener  //监听器
public class FreeMarkerListener implements ServletContextListener {
    // 设置参数
    public static final String TEMPLATE_KEY = "_template_"; // 键值对来读取值
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // 配置版本
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_0);
        // 配置 FreeMarker页面所在的路径
        try {
            cfg.setDirectoryForTemplateLoading(new File("F:\\Code-Java\\Projects\\ChartRoom_WebSocket\\src\\main\\webapp"));
        } catch (IOException e) {
            System.err.println("文件未找到！！");
            e.printStackTrace();
        }

        // 配置页面编码
        cfg.setDefaultEncoding(StandardCharsets.UTF_8.displayName());
        // 将配置 Configuration 写入文件中
        servletContextEvent.getServletContext().setAttribute(TEMPLATE_KEY,cfg);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

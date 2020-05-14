package org.iqqcode.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-30 17:12
 * @Description:该类是一个配置类，它的作用和bean.xml是一样的
 */
@ComponentScan("org.iqqcode")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}

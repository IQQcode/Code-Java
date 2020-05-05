package org.iqqcode.web;

import org.iqqcode.dao.UserDao;
import org.iqqcode.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-23 11:05
 * @Description:模拟用户注册的表现层
 * 获取spring的Ioc核心容器，并根据id获取对象
 *
 * ApplicationContext的三个常用实现类：
 *      ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了。(更常用)
 *      FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件(必须有访问权限）
 *      AnnotationConfigApplicationContext：它是用于读取注解创建容器的
 *
 * 核心容器的两个接口引发出的问题：
 *  ApplicationContext:     单例对象适用
 *      它在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象。
 *
 *  BeanFactory:            多例对象使用
 *      它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象。
 */
public class RegistClient {
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2.根据id获取Bean对象
        UserDao userDao = ac.getBean("userDao",UserDao.class); //通过反射来创建对象
        UserService userService = (UserService) ac.getBean("userService"); //Object类型
        userDao.regist();

        //--------BeanFactory----------
        /*Resource resource = (Resource) new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        UserService as  = (UserService)factory.getBean("accountService");
        System.out.println(as);*/
    }
}

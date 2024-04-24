package com.yu.spring6.iocxml.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestUserDao
 * @Description TODO
 * @Author YU
 * @Date 2024/4/6 12:23
 * @Version 1.0
 **/
public class TestUserDao {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserDao user = context.getBean(UserDao.class);
        System.out.println(user);
        user.run();
    }
}

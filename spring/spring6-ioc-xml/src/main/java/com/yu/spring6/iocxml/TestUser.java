package com.yu.spring6.iocxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestUser
 * @Description TODO
 * @Author YU
 * @Date 2024/4/6 12:06
 * @Version 1.0
 **/
public class TestUser {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        // 根据id获取bean
        User user = (User) context.getBean("user");
        System.out.println(user);

        // 根据类型获取bean
        User user2 = context.getBean(User.class);
        System.out.println(user2);

        // 根据id和类型
        User user3 = context.getBean("user", User.class);
        System.out.println(user3);



    }
}

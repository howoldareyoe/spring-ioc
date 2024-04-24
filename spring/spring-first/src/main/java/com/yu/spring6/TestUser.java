package com.yu.spring6;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestUser
 * @Description TODO
 * @Author YU
 * @Date 2024/4/5 15:54
 * @Version 1.0
 **/
public class TestUser {

    // 创建logger对象
    private Logger logger = LoggerFactory.getLogger(TestUser.class);


    @Test
    public void testUser(){
        // 加载spring配置文件，对象创建
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        // 获取创建的对象
        User user = (User) context.getBean("user");
        System.out.println(user);

        // 使用对象调用方法进行测试
        user.add();

        //手动写日志
        logger.debug("执行调用成功");
    }

    // 反射创建对象
    @Test
    public void testUser1() throws Exception {
        // 获取类Class对象
        Class clazz = Class.forName("com.yu.spring6.User");
        //调用方法创建对象
//        User o = (User) clazz.newInstance();
        User o = (User)clazz.getDeclaredConstructor().newInstance();
        System.out.println(o);

    }
}

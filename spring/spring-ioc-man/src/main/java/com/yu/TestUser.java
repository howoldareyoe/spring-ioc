package com.yu;

import com.yu.bean.AnnotationApplicationContext;
import com.yu.bean.ApplicationContext;
import com.yu.service.UserService;

/**
 * @ClassName TestUser
 * @Description TODO
 * @Author YU
 * @Date 2024/4/7 19:37
 * @Version 1.0
 **/
public class TestUser {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationApplicationContext("com.yu");
        UserService userService = (UserService) context.getBean(UserService.class);
        userService.add();
    }
}

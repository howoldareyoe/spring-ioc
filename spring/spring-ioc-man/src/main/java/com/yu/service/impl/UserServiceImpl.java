package com.yu.service.impl;

import com.yu.anno.Bean;
import com.yu.anno.Di;
import com.yu.dao.UserDao;
import com.yu.service.UserService;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author YU
 * @Date 2024/4/7 17:59
 * @Version 1.0
 **/
@Bean
public class UserServiceImpl implements UserService {

    @Di
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service....");
        userDao.add();
    }
}

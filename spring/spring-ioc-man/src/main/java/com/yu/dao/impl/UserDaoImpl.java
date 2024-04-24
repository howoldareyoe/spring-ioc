package com.yu.dao.impl;

import com.yu.anno.Bean;
import com.yu.dao.UserDao;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author YU
 * @Date 2024/4/7 18:01
 * @Version 1.0
 **/
@Bean
public class UserDaoImpl implements UserDao {

    @Override
    public void add() {
        System.out.println("dao........");
    }
}

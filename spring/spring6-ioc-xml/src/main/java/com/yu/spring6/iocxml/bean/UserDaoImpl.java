package com.yu.spring6.iocxml.bean;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author YU
 * @Date 2024/4/6 12:21
 * @Version 1.0
 **/
public class UserDaoImpl implements UserDao{
    @Override
    public void run() {
        System.out.println("run.......");
    }
}

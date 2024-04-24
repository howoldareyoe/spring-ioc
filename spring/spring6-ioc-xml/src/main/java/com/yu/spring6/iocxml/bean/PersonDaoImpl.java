package com.yu.spring6.iocxml.bean;

/**
 * @ClassName PersonDaoImpl
 * @Description TODO
 * @Author YU
 * @Date 2024/4/6 12:25
 * @Version 1.0
 **/
public class PersonDaoImpl implements UserDao{
    @Override
    public void run() {
        System.out.println("Person  run....");
    }
}

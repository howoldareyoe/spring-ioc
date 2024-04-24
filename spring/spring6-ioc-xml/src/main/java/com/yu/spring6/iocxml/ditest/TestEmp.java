package com.yu.spring6.iocxml.ditest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestEmp
 * @Description TODO
 * @Author YU
 * @Date 2024/4/6 14:51
 * @Version 1.0
 **/
public class TestEmp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-diarray.xml");
        Emp emp = (Emp) context.getBean("emp");
        emp.work();
    }
}

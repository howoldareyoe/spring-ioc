package com.yu.spring6.iocxml.di;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestBook
 * @Description TODO
 * @Author YU
 * @Date 2024/4/6 12:40
 * @Version 1.0
 **/
public class TestBook {

    @Test
    public void testSetter(){
        ApplicationContext context  = new ClassPathXmlApplicationContext("bean-di.xml");
        Book book = context.getBean("book",Book.class);
        System.out.println(book.toString());
    }

    @Test
    public void testCon(){
        ApplicationContext context  = new ClassPathXmlApplicationContext("bean-di.xml");
        Book book = context.getBean("bookCon",Book.class);
        System.out.println(book.toString());
    }
}

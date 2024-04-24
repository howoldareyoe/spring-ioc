package com.yu.spring6.iocxml.di;

/**
 * @ClassName Book
 * @Description TODO
 * @Author YU
 * @Date 2024/4/6 12:30
 * @Version 1.0
 **/
public class Book {
    private String bname;
    private String author;

    public Book() {
    }

    public Book(String bname, String author) {
        System.out.println("有参构造");
        this.bname = bname;
        this.author = author;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

package com.yu.spring6.iocxml.ditest;

import java.util.Arrays;

/**
 * @ClassName Emp
 * @Description TODO
 * @Author YU
 * @Date 2024/4/6 14:34
 * @Version 1.0
 **/
public class Emp {
    private Dept dept;
    private String ename;
    private Integer age;
    // 爱好
    private String[] loves;

    public String[] getLoves() {
        return loves;
    }

    public void setLoves(String[] loves) {
        this.loves = loves;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void work(){
        System.out.println(ename+"员工在工作"+age);
        dept.info();
        System.out.println(Arrays.toString(loves));
    }
}

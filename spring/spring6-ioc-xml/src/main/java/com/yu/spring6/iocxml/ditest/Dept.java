package com.yu.spring6.iocxml.ditest;

import java.util.List;

/**
 * @ClassName Dept
 * @Description TODO
 * @Author YU
 * @Date 2024/4/6 14:34
 * @Version 1.0
 **/
public class Dept {

    private String dname;

    private List<Emp> empList;

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void info(){
        System.out.println("部门名称：" + dname);
        empList.forEach((e)->{
            System.out.println(e.getEname());
        });
    }
}

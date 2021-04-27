package com.waylau.spring.cloud.weather.vo;

/**
 * @author: wangxiaobo
 * @create: 2021-04-26 18:07
 **/
public class Classroom {
    private int id;
    private String name;
    private int grade;
    public Classroom(){
        super();
    }
    public Classroom(int id ,String name ,int grade){
        super();
        this.id=id;
        this.name=name;
        this.grade=grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}

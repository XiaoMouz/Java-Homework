package com.mou.app.person;

public class Student extends People{
    private String id;
    private String grade;
    private String major;
    private String school;

    public void doHomework(){
        System.out.println(getName()+"正在写作业");
    }
    public void studyCourse(){
        System.out.println(getName()+"正在学习"+getMajor());
    }
    @Override
    public void eat(String food) {
        System.out.println(getName()+"喜欢吃"+food);
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
}

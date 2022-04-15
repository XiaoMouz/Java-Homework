package com.mou.app.person;

public class Teacher extends People{
    private String title;
    private String teachCourses;
    private String school;
    private int salary;

    public void teaching(){
        System.out.println(getName()+"正在教"+getTeachCourses()+"课程学生");
    }
    public void markWork(){
        System.out.println(getName()+"正在批改作业");
    }
    @Override
    public void eat(String food) {
        System.out.println(getName()+"喜欢吃"+food);
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeachCourses() {
        return teachCourses;
    }
    public void setTeachCourses(String teachCourses) {
        this.teachCourses = teachCourses;
    }

    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }

    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
}

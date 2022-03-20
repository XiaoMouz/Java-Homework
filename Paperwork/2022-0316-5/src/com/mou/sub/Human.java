package com.mou.sub;

public class Human {
    public static String name;
    public static int age;
    public static  char gender;

    public void sayHello(){
        System.out.println("我是"+ name+"，今年"+ age+"岁，是"+ gender+"生");
    }

    public void setProfile(String name,int age,char gender){
        Human.name = name;
        Human.age = age;
        Human.gender = gender;
    }
}

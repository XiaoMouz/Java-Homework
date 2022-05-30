package com.mou.app.main;

public class Parent1{
    Parent1(String s){
        System.out.println(s);
    }
}

public class Parent2 extends Parent1{
    Parent2(){
        System.out.println("1");
    }
}


public class Child extends Parent2 {
    public static void main(String[] args){
        Child child = new Child();
    }
}

package com.mou.base;

import com.mou.base.util.CatType;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Cat {
    public String name,type,color;
    int age;
    double width;

    public Cat(String name){
        this.name = name;
    }

    /**
     * 设置猫的各种信息，所有提示已就绪，直接调用即可
     */
    public void setInfo(){
        Scanner input;
        boolean status=true;
        String buffer;
        System.out.println("现有以下猫类可选");
        for (CatType i : CatType.values()){
            System.out.print(i+"|");
        }
        System.out.println();
        //种类选择
        while (status){
            input = new Scanner(System.in);
            buffer = input.next();
            for (CatType i : CatType.values()){
                try{
                    CatType.valueOf(buffer);
                    this.type = buffer;
                    status = false;
                    break;
                }catch (IllegalArgumentException error ){
                    break;
                }
            }
            if(status){
                System.out.println("你的输入有误");
            }
        }
        //颜色判定
        System.out.println("输入猫的颜色");
        String colorRegular="^[\\u4e00-\\u9fa5]{1,2}[色]";
        while (true){
            input = new Scanner(System.in);
            buffer = input.next();
            if(Pattern.matches(colorRegular,buffer)){
                this.color = buffer;
                break;
            }else{
                System.out.println("输入有误");
            }
        }

        //年龄判定
        System.out.println("输入猫的年龄");
        while(true){
            input=new Scanner(System.in);
            try{
                this.age = input.nextInt();
            }catch (InputMismatchException error){
                System.out.println("输入有误");
            }
            if(0<this.age&&this.age<10){
                break;
            }else{
                System.out.println("输入有误");
            }
        }

        //体重判定
        System.out.println("输入猫的体重，以kg计算");
        while (true){
            input = new Scanner(System.in);
            try{
                this.width = input.nextDouble();
            }catch (InputMismatchException error){
                System.out.println("输入有误");
            }
            if(0.0<this.width&&this.width<20.0){
                break;
            }else{
                System.out.println("输入有误");
            }
        }
    }

    public void printCat(){
        System.out.println(this.name+"是只"+this.color+"的"+this.type+"，现在已经"+this.age+"岁了，有"+this.width+"kg重");
    }

    public void yelling(){
        System.out.println(this.name+":miaow~");
    }

    public void playToy(String toy){
        System.out.println(this.name+"正在玩"+toy);
    }

    public void playWithOtherCat(Cat cat){
        System.out.println(this.name+"正在和"+cat.name+"玩");
    }
}

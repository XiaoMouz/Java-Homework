package com.test.main;

public class Default {

    public static void main(String args[]){
        Vehicle vehicle = new Car();
        vehicle.print();//这样就能比较方便的调用了
        Vehicle.blowHorn();
        System.out.println(vehicle.pp(11));
    }
}

interface Vehicle {
    default void print(){
        System.out.println("我是一辆车!");
    }

    static void blowHorn(){
        System.out.println("按喇叭!!!");
    }

    default int pp(int money){
        return money;
    }
}

interface FourWheeler {
    default void print(){
        System.out.println("我是一辆四轮车!");
    }
}

class Car implements Vehicle, FourWheeler {
    public void print(){
        Vehicle.super.print();//通过 接口.super.方法名 来调用默认方法
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("我是一辆汽车!");
    }

    public int pp(int money){
        int cash = Vehicle.super.pp(money);
        return cash*2;
    }
}

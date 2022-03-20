package com.mou.main;

import com.mou.base.Cat;

import java.util.Scanner;

public class CatMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("输入第一只猫的名字");
        Cat a1 = new Cat(input.next());
        a1.setInfo();

        System.out.println("输入第二只猫的名字");
        input = new Scanner(System.in);
        Cat a2 = new Cat(input.next());
        a1.printCat();
        a1.yelling();
        a1.playToy("毛线球");
        a1.playWithOtherCat(a2);
    }
}

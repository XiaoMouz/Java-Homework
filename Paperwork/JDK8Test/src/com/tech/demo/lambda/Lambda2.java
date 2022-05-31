package com.tech.demo.lambda;

//更多的玩法
public class Lambda2 {
    public static void main(String[] args) {
        /*A 这是之前的方法，应对的是无参无返回值的Lambda表达式
        Egg egg1 = () -> { System.out.println("1");};
        egg1.make();
        */

        /*B 有参无返回值版本lambda
        Egg egg = (int num) ->{
            System.out.println(num);
        };
        egg.make(50);
        */

        /*C 无参有返回值版本Lambda
        Egg egg = () ->{
            return 50;
        };
        System.out.println(egg.make());
        */

        //D 有参有返回值版本Lambda
        Egg egg = (int a)->{
            return a++;
        };

        System.out.println(egg.make(50));
    }

}

interface Egg{
    //void make(); A
    //void make(int a); B
    //int make(); C
    int make(int a);//D
}

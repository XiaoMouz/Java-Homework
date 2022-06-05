package com.tech.demo.lambda;

public class Lambda3 {
    public static void main(String[] args) {
        SystemDefender sd = (int a ) -> {
            return a++;
        };
        //其中，int a是可以不写的，如果有更多也能不写前面的类型
        SystemDefender sd2 = (a) -> {
            return a++;
        };

        //其次，如果只有一个形参，括号也能省略
        SystemDefender sd3 = a ->{
            return a++;
        };

        //再者，如果只有一条语句，方法体括号也能省略
        //如果是返回语句则可以省略return
        SystemDefender sd4 = a -> ++a;

        //Lambda实际上不是匿名内部类，而是匿名函数，并且相当于方法重写
        //并且Lambda表达式使用时需要接口而且接口只有能有一个抽象方法，不过接口中可以有其它方法

        //SystemDefender sd5 = a -> System.out.println(a);
    }
}

interface SystemDefender{
    int defence(int a);
}

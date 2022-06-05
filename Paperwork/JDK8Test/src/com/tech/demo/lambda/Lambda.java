package com.tech.demo.lambda;

public class Lambda {
    public static void main(String[] args) {
        //Way C:使用匿名内部类
        Animal monkey = new Animal() {
            @Override
            public void eat() {
                System.out.println("w");
            }
        };


        //New Way in Java 8:使用Lambda表达式
        Animal monkey2 = () -> { //()括号是形参，{}就相当于方法体  这样一整个写法就是相当于把eat重写了
            System.out.println("wow");
        }; //Lambda表达式只有一个抽象方法时才能使用
        monkey.eat();
        monkey2.eat();
        //即: (参数) -> 运算符 {方法体/表达式}
        //Lambda表达式是一种匿名函数(不是匿名内部类)

    }

    //Way B:建一个内部类
    class Monkey2 implements Animal{
        @Override
        public void eat() {

        }
    }
}



interface Animal{
    void eat();
}

//比如我要在主函数中使用一个的Animal的子类Monkey，我可以有三种表达方式
//Way A:建一个类
class Monkey implements Animal{
    @Override
    public void eat() {

    }
}
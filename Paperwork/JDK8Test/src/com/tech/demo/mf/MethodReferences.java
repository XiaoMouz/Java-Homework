package com.tech.demo.mf;

import java.util.Arrays;
import java.util.List;

//方法引用
public class MethodReferences {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        //正常通过lambda表达式进行输出
        list.forEach(x->{System.out.println(x);});

        //使用方法引用
        //如果要对传递过来的参数不进行任何处理就进行使用则可以使用这个写法
        list.forEach(System.out::println);
    }
}

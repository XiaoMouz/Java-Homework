package com.tech.demo.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Demo2 {
    //Stream和IO不是同一个东西
    //Stream是为容器(集合、键值对)对象功能进行增强，是用来对容器对象进行各种便利的高效的聚合操作或大批量操作
    //Stream和Lambda的配合也还不错，并且也有串行和并行操作方法，对多核有优化

    public static void main(String[] args) {
        //将一个无序、有重复并且数量巨大的数据 去重并排列
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,13,4,15,6,17,8,19,2,15,223,4552);
        //基本的就是，先去重，遍历list，然后把数据保存到另一个集合对象中去

        //而流式编程只要
        // 1-获取stream对象
        Stream<Integer> streamlist = list.stream();

        // 2-中间操作
        streamlist =streamlist.distinct() //去重
                                .sorted()//升序写法
                                .sorted((x,y)->y-x)//降序写法，使用Lambda
                                //.limit(4)//取集合中的前4个值
                                //.skip(3)//跳过前3个值
                                .map(a->a+8)//向里面所有元素+8
                                //.filter(x->x>30)
                                ;

        // 3-终止操作  eg:终止操作只能执行一个
        //streamlist.forEach(System.out::println);//将集合中的内容进行遍历输出
            System.out.println(streamlist.max((x,y)->x));//取最大值
        //System.out.println(streamlist.count());
        //System.out.println(streamlist.findFirst().get());
        //因此若全部取消注释会出现异常
    }
}

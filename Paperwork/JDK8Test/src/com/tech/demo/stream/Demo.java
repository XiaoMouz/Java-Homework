package com.tech.demo.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Demo {
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
                                .sorted();//排序

        // 3-终止操作
        List<Integer> set = new ArrayList<>();
        streamlist.forEach(set::add);//将集合中的内容进行遍历输出
        set.forEach(System.out::println);
    }
}

package com.tech.demo.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo3 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,45,1212,124,333,236,352367};
        IntStream stream = Arrays.stream(arr);//串行流

        //获得Stream对象有两种分类，一种是串行流，一种是并行流
        //Demo1,2用的便是串行流

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,13,4,15,6,17,8,19,2,15,223,4552);

        Stream<Integer> integerStreamList = list.parallelStream();//这个就是并行流
    }
}

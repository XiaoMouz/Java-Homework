package com.tech.demo.fi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class note {
    /**
     *
     * java内置四大函数式接口
     *
     * Consumer<T> :消费型接口
     * 			void accept(T t);
     *
     * Supplier<T> :供给型接口
     * 			T get();
     *
     * Function<T,R> :函数型接口
     * 			R apply(T t);
     *
     * Predicate<T> :断言型接口
     * 			boolean test(T t);
     *
     */
        //Consumer<T> 消费型接口：
        public void test1(){
            happy(1000,(m) ->System.out.println("喜欢大宝剑，消费："+m+"元"));
        }
        public void happy(double money, Consumer<Double> con){
            con.accept(money);
        }

        //Supplier<T> 供给型接口:
        //需求：产生指定个数的整数，并放入集合中
        public void test2(){
            List<Integer> numList=getNumList(10, ()->(int)(Math.random()*100));
            for (Integer num : numList) {
                System.out.println(num);
            }
        }
        public List<Integer> getNumList(int num, Supplier<Integer> sup){
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < num; i++) {
                Integer n=sup.get();
                list.add(n);
            }
            return list;
        }

        //Function<T,R> 函数型接口:
        public void test3(){
            String newStr=strHandler("\t\t\t 啦啦啦德玛西亚  ", (str)->str.trim());
            System.out.println(newStr);

            String subStr=strHandler("无与伦比，为杰沉沦", (str)->str.substring(5,9));
            System.out.println(subStr);
        }
        //需求：处理字符串
        public String strHandler(String str, Function<String,String> fun){
            return fun.apply(str);
        }

        //Predicate<T> 断言型接口：
        public void test4(){
            List<String> list= Arrays.asList("Hello","jj","Lambda","www","ok");
            List<String> strList=filterStr(list, (s)->s.length()>3);
            for (String string : strList) {
                System.out.println(string);
            }
        }
        //需求：将满足条件的字符串，放入集合中
        public List<String> filterStr(List<String> list, Predicate<String> pre){
            List<String> strList=new ArrayList<>();
            for ( String str : list) {
                if(pre.test(str)){
                    strList.add(str);
                }
            }
            return strList;
        }
}


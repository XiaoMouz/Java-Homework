package com.mou.lambda;

import java.text.Collator;
import java.util.*;
import java.util.stream.Stream;

public class CitySort {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<String>();
        Collections.addAll(cities,"安阳","上海","北京","南昌","上饶","深圳","鞍山","广州","乌鲁木齐","安庆","张家口");

        Collections.sort(cities,(s1,s2)-> Collator.getInstance(Locale.CHINESE).compare(s1,s2));
        cities.forEach(System.out::println);


    }
}

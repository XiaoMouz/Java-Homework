package com.test.main;

import java.time.Month;
import java.time.ZonedDateTime;
import java.time.ZoneId;

public class OtherTimeZoneTest {
    public static void main(String args[]){
        OtherTimeZoneTest java8tester = new OtherTimeZoneTest();
        java8tester.testZonedDateTime();
    }

    public void testZonedDateTime(){
        //通过字符串转换为ZonedDateTime对象
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1+"时区:"+date1.getZone());

        //通过字符串转换设置时区
        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);
        //通过指定时区来获得该时区的日期时间，返回ZonedDateTime对象，并且可以拿去parse，真好
        ZonedDateTime data2 = ZonedDateTime.now(id);
        System.out.println(data2);

        //获得data2的月、日、秒
        Month month = data2.getMonth();
        int day = data2.getDayOfMonth();
        int seconds = data2.getSecond();
        System.out.println("月: " + month +", 日: " + day +", 秒: " + seconds);

        //获取当前系统所在地的时区
        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);
    }
}

package com.test.main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalField;

public class TimeZoneTest {
    public static void main(String args[]){
        TimeZoneTest j8ttest = new TimeZoneTest();
        j8ttest.testLocalDateTime();

        LocalDateTime date = LocalDateTime.now();
        System.out.println(date.getDayOfWeek());
        date = date.withDayOfMonth(30).withYear(2999).withMonth(2);
        System.out.println(date);
    }

    public void testLocalDateTime(){



        // 获取当前的日期时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间: " + currentTime);

        //转换成年月日模式
        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);

        //取其中的部分值（月、日、秒)
        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();
        System.out.println("月: " + month +", 日: " + day +", 秒: " + seconds);

        //返回一个更改了相关参数的LocalDateTime副本，如果时间无效则会引发异常，日除外
        LocalDateTime date2 = currentTime.withDayOfMonth(30).withYear(2012).withMonth(2);
        System.out.println("date2: " + date2);

        //通过字符串转换时间日期
        LocalDateTime data5 = LocalDateTime.parse("2022-06-01T03:02:13.045");
        System.out.println("T"+data5);

        // 生成一个指定的日期的对象 12日 一月 2077年
        LocalDate date3 = LocalDate.of(2077,Month.JANUARY, 12);
        System.out.println("date3: " + date3);

        // 生成一个指定时间的对象 22 小时 15 分钟
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);

        // 通过字符串转换时间
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
    }
}

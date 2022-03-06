package com.mou.util;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GetInfo {

    /**
     * 通过正则表达式来确保字符串输入合法
     * @param print 输入前的提示信息
     * @param regex 需要匹配的正则表达式
     * @return 获得的合法字符串
     */
    public static String inputStr(String print,String regex){
        System.out.println(print);
        Scanner get;
        String input = null;
        while(true){
            get = new Scanner(System.in);
            try{
                input = get.next(regex);
                System.out.println("录入成功");
                break;
            }catch (InputMismatchException error){
                System.out.println("输入有误");
            }
        }
        return input;
    }

    /**
     * 用于检查数字大小合理性的方法，输入最大值与最小值与需要的提示信息，返回一个整数
     * @param tips 输入前的提示信息
     * @param max 可以接受的最大值
     * @param min 可以接受的最小值
     * @return 一个处于max与min之间的整数
     */
    public static int inputNumber(String tips,int min,int max) {
        Scanner input;
        String buffer;
        System.out.println(tips);
        int transGo = 0;
        while(true){
            input = new Scanner(System.in);
            buffer = input.next();
            try {
                transGo = Integer.parseInt(buffer);
            } catch (NumberFormatException error) {
                System.out.println("输入有误，请重输");
                continue;
            }
            if(transGo >= min && transGo <= max){
                System.out.println("录入成功");
                return transGo;
            }else{
                System.out.println("输入有误，请重输");
            }
        }
    }

    /**
     * 用于检查数字大小合理性的方法，输入最大值与最小值与需要的提示信息，返回一个双精度数
     * @param tips 输入前的提示信息
     * @param max 可以接受的最大值
     * @param min 可以接受的最小值
     * @return 一个处于max与min之间的双精度数
     */
    public static Double inputNumber(String tips,double min,double max) {
        Scanner input;
        String buffer;
        System.out.println(tips);
        double transGo = 0;
        while(true){
            try {
                input = new Scanner(System.in);
                buffer = input.next();
                transGo = Double.parseDouble(buffer);
            } catch (NumberFormatException error) {
                System.out.println("输入有误，请重输");
                continue;
            }
            if(transGo >= min && transGo <= max){
                System.out.println("录入成功");
                return transGo;
            }else{
                System.out.println("输入有误，请重输");
            }
        }
    }

    /**
     * 用于纯粹接收double类型的数字
     * @param min 可接受的最小值
     * @param max 可接受的最大值
     * @return 一个处于最小值与最大值之间的双精度数
     */
    public static Double inputNumber(double min,double max) {
        Scanner input;
        String buffer;
        double transGo = 0;
        while(true){
            try {
                input = new Scanner(System.in);
                buffer = input.next();
                transGo = Double.parseDouble(buffer);
            } catch (NumberFormatException error) {
                System.out.println("输入有误，请重输");
                continue;
            }
            if(transGo >= min && transGo <= max){
                System.out.println("录入成功");
                return transGo;
            }else{
                System.out.println("输入有误，请重输");
            }
        }
    }

    /**
     * 用于收集personnel数量的学生的count个科目成绩
     * @param count 科目数量
     * @param personnel 学生数量
     * @param aMax 单科最大分
     * @param aMin 单科最小分
     * @return 包含所有学生与成绩的集合
     */
    public static ArrayList<ArrayList<Double>> inputAchievement(int count,int personnel,double aMax,double aMin){
        System.out.println("开始输入您的成绩，您此次要录入"+personnel+"人的"+count+"科成绩");
        ArrayList<ArrayList<Double>> student = new ArrayList<>();
        ArrayList<Double> counts = new ArrayList<>();
        for (int i=0;i<=personnel;i++){
            for (int j=0;j<=count;j++){
                System.out.println("现在输入的是第"+(i+1)+"位学生的第"+(j+1)+"科成绩");
                counts.add(inputNumber(aMin,aMax));
            }
            student.add(counts);
        }
        return student;
    }
}

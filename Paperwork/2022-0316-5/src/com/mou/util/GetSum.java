package com.mou.util;

public class GetSum {
    /**
     * 得到两个整型数字的和
     * @param a 第一个数
     * @param b 第二个数
     * @return 两数总和
     */
    public static int getIntSum(int a,int b){
        return a+b;
    }

    /**
     * 得到三个整型数字的和
     * @param a 第一个数
     * @param b 第二个数
     * @param c 第三个数
     * @return 三数之和
     */
    public static int getIntSum(int a,int b,int c){
        return a+b+c;
    }

    /**
     * 得到多个整型数之和
     * @param args 任意数量的数
     * @return 这些数的总和
     */
    public static int getIntSum(int... args){
        int sum=0;
        for (int arg : args) {
            sum += arg;
        }
        return sum;
    }

    /**
     * 得到两个实型变量的和
     * @param a 一个double数
     * @param b 另一个double数
     * @return 这两个double之和
     */
    public static double getSum(double a,double b){
        return a+b;
    }
    /**
     * 得到两个实型变量的和
     * @param a 一个float数
     * @param b 另一个float数
     * @return 这两个float之和
     */
    public static float getSum(float a,float b){
        return a+b;
    }
    /**
     * 得到两个实型变量的和
     * @param a 一个long数
     * @param b 另一个long数
     * @return 这两个long之和
     */
    public static long getSum(long a,long b){
        return a+b;
    }
}

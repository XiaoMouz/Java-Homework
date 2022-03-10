package com.mou.hmw.util;

import java.util.Random;

public class NumberHandle {
    /**
     * 用于创建一个已由随机数填满的Int数组
     * @param maxLength 数组最大长度
     * @return 长度为maxLength的数组
     */
    public static int[] createIntGroup(int maxLength){
        int[] returnGroup=new int[maxLength];
        returnGroup=randomCreateInt(returnGroup);
        return returnGroup;
    }

    /**
     * 一个用于填满Int数组的伪随机数生成方法
     * @param in 需要填满的数组
     * @return 已填满的数组
     */
    private static int[] randomCreateInt(int[] in){
        Random r = new Random();
        for(int i=0;i<in.length;i++){
            r=new Random(r.nextLong());
            in[i] = r.nextInt(999999);
        }
        return in;
    }

    /**
     * 将字符串转换为Int类型，如遇到问题则会返回0
     * @param buffer 需要转换的字符串
     * @return 转换后的字符串
     */
    public static int returnNumber(String buffer) {
        int transGo;
        try { //判断输入是否符合数字条件
            transGo = Integer.parseInt(buffer);
        } catch (NumberFormatException error) {
            return 0;
        }
        //大小判断
        return transGo;
    }

    /**
     * 将字符串转换为Double类型，如遇到问题则会返回0
     * @param buffer 需要转换的字符串
     * @return 转换后的字符串
     */
    public static double returnDoubleNumber(String buffer) {
        Double transGo;
        try { //判断输入是否符合数字条件
            transGo = Double.parseDouble(buffer);
        } catch (NumberFormatException error) {
            return 0;
        }
        //大小判断
        return transGo;
    }

    /**
     * 检查字符串是否能够转换为Double类型，如遇到问题则会返回false
     * @param buffer 需要检测的字符串
     * @return 判断结果
     */
    public static boolean checkNumber(String buffer) {
        try { //判断输入是否符合数字条件
            Double.parseDouble(buffer);
        } catch (NumberFormatException error) {
            return false;
        }
        //大小判断
        return true;
    }


    /**
     * 获取int数组中的最大数或最小数
     * @param in 一个int数组
     * @param mode 模式
     * @return 最大数或最小数
     */
    public static int groupMaxOrMinNumber(int[] in,groupHandleMode mode){
        if(mode==groupHandleMode.MAX){
            int max=in[0];
            for (int j : in) {
                if (j > max) {
                    max = j;
                }
            }
            return max;
        }else if(mode==groupHandleMode.MIN){
            int min=in[0];
            for (int j : in) {
                if (j < min) {
                    min = j;
                }
            }
            return min;
        }else{
            return 0;
        }
    }

    /**
     * 获取Double数组中的最大数或最小数
     * @param in 一个Double数组
     * @param mode 模式
     * @return 最大数或最小数
     */
    public static Double groupMaxOrMinNumber(Double[] in,groupHandleMode mode){
        if(mode==groupHandleMode.MAX){
            double max=in[0];
            for (double j : in) {
                if (j > max) {
                    max = j;
                }
            }
            return max;
        }else if(mode==groupHandleMode.MIN){
            double min=in[0];
            for (double j : in) {
                if (j < min) {
                    min = j;
                }
            }
            return min;
        }else{
            return 0.0;
        }
    }

    /**
     *  计算int数组总合
     * @param in int数组
     * @return 元素总和
     */
    public static int getSum(int[] in){
        int sum=0;
        for(int i=0;i<in.length;i++){
            sum+=in[i];
        }
        return sum;
    }

    /**
     *  计算Double数组总合
     * @param in Double数组
     * @return 元素总和
     */
    public static double getSum(Double[] in){
        double sum=0;
        for (Double aDouble : in) {
            sum += aDouble;
        }
        return sum;
    }
}

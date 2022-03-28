package com.mou.util;

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
    public static int[] randomCreateInt(int[] in){
        Random r = new Random();
        for(int i=0;i<in.length;i++){
            r=new Random(r.nextLong());
            in[i] = r.nextInt(999999);
        }
        return in;
    }

    /**
     * 得到个int随机数
     * @return int
     */
    public static int createRandomNumber(int max){
        Random r = new Random();
        r=new Random(r.nextLong());
        return r.nextInt(max);
    }

    /**
     * 得到平均值
     * @param nums 一个int数组
     * @return double数
     */
    public static double getAvg(int[] nums){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        return (double) sum / (double) nums.length;
    }

    /**
     * 获取int数组中的最大数或最小数
     * @param in 一个int数组
     * @param mode 模式
     * @return 最大数或最小数
     */
    public static int groupMaxOrMinNumber(int[] in, GroupHandleMode mode){
        if(mode== GroupHandleMode.MAX){
            int max=in[0];
            for (int j : in) {
                if (j > max) {
                    max = j;
                }
            }
            return max;
        }else if(mode== GroupHandleMode.MIN){
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
    public static Double groupMaxOrMinNumber(Double[] in, GroupHandleMode mode){
        if(mode== GroupHandleMode.MAX){
            double max=in[0];
            for (double j : in) {
                if (j > max) {
                    max = j;
                }
            }
            return max;
        }else if(mode== GroupHandleMode.MIN){
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

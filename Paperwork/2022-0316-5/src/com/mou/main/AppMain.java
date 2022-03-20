package com.mou.main;

import com.mou.util.Input;
import com.mou.util.NumberHandle;
import com.mou.util.groupHandleMode;
import java.util.Arrays;

public class AppMain {
    public static void main(String[] args) {
        //Q1:定义用于输入n个数的方法（调用util包下Input类中确保输入一定范围数的方法实现）。
        System.out.println("你要输入几个数字？");
        int[] getNums = Input.getAppointNumbers(Input.checkUserInput("错误，重输"));
        for (int i=0;i<getNums.length;i++){
            System.out.print(getNums[i]);
            if(i!=(getNums.length)-1){
                System.out.print('|');
            }
        }
        System.out.println();

        //Q2现随机产生n个数，求其中的最大值、最小值、平均值以及排序后输出。
        int[] rNums = NumberHandle.createIntGroup(NumberHandle.createRandomNumber(100));

        System.out.println("排序前:");
        for(int i=0;i<rNums.length;i++){
            System.out.print(rNums[i]+"|");
            if(i!=0&&i%5==0){
                System.out.println();
            }
        }

        System.out.println();

        Arrays.sort(rNums);
        System.out.println("排序后:");
        System.out.println("最小数:"+NumberHandle.groupMaxOrMinNumber(rNums, groupHandleMode.MIN)+"|最大数:"+NumberHandle.groupMaxOrMinNumber(rNums, groupHandleMode.MAX)+"|总和:"+NumberHandle.getSum(rNums)+"|平均数:"+NumberHandle.getSum(rNums)/rNums.length);
        System.out.println();
        for(int i=0;i<rNums.length;i++){
            System.out.print(rNums[i]+"|");
            if(i!=0&&i%5==0){
                System.out.println();
            }
        }
    }
}

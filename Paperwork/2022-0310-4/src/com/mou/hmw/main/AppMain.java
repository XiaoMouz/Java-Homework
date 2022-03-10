package com.mou.hmw.main;

import com.mou.hmw.util.NumberHandle;
import com.mou.hmw.util.groupHandleMode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        Scanner input = null;
        int maxLength;
        System.out.print("输入需要生成的个数");
        while(true){
            input=  new Scanner(System.in);
            maxLength = NumberHandle.returnNumber(input.next());
            if(maxLength<=0.0){
                System.out.println("输入有误，请重试");
            }else{
                break;
            }
        }
        int[] aIntGroup = NumberHandle.createIntGroup(maxLength);
        Arrays.sort(aIntGroup);
        int max = NumberHandle.groupMaxOrMinNumber(aIntGroup, groupHandleMode.MAX);
        int min = NumberHandle.groupMaxOrMinNumber(aIntGroup,groupHandleMode.MIN);
        int sum = NumberHandle.getSum(aIntGroup);
        int avg = sum/aIntGroup.length;
        System.out.println("最小数:"+min+"|最大数:"+max+"|总和:"+sum+"|平均数:"+avg);
        for(int i=0;i<aIntGroup.length;i++){
            System.out.print(aIntGroup[i]+"|");
            if(i!=0&&i%5==0){
                System.out.println();
            }
        }
    }
}

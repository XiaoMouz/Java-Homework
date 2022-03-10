package com.mou.hmw.main;

import com.mou.hmw.util.NumberHandle;
import com.mou.hmw.util.groupHandleMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//本次有两个作业，为了方便管理文件因此全部集中在一起，方法也大致相同可以混用
public class AppSubMain {
    public static void main(String[] args) {
        ArrayList<Double> doubleList = new ArrayList<Double>();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入你要录入的数字，以#结束");
        String buffer;
        while(!(buffer=input.nextLine()).equals("#")){
            if(NumberHandle.checkNumber(buffer)){
                doubleList.add(NumberHandle.returnDoubleNumber(buffer));
                input = new Scanner(System.in);
                System.out.println("录入成功，如需结束请输入#");
            }else{
                input = new Scanner(System.in);
                System.out.println("输入有误");
            }
        }

        Double[] doubleGroup = new Double[doubleList.size()];
        for(int i=0;i<doubleList.size();i++){
            doubleGroup[i]=doubleList.get(i);
        }
        Arrays.sort(doubleGroup);
        System.out.println("最小数:"+NumberHandle.groupMaxOrMinNumber(doubleGroup, groupHandleMode.MIN)+"|最大数:"+NumberHandle.groupMaxOrMinNumber(doubleGroup, groupHandleMode.MAX)+"|总和:"+NumberHandle.getSum(doubleGroup)+"|平均数:"+NumberHandle.getSum(doubleGroup)/doubleGroup.length);
        for(int i=0;i<doubleGroup.length;i++){
            System.out.print(doubleGroup[i]+"|");
            if(i!=0&&i%5==0){
                System.out.println();
            }
        }
    }
}

package com.mou.util;

import java.util.Random;
import java.util.Scanner;

public class Input {

    /**
     * 收集传入数个数的数字返回相应长度数组
     * @param quantity 要搜集的数字个数
     * @return 验证过完整性的数组
     */
    public static int[] getAppointNumbers(int quantity){
        int[] finale = new int[quantity];
        for(int i=0;i<finale.length;i++){
            System.out.println("输入第"+(i+1)+"个数字");
                finale[i] = checkUserInput("错误，重试");
            }
        return finale;
    }

    /**
     * 用于收集合法int数字的方法
     * @param errorMsg 在错误时需要显示的信息
     * @return 一个正常的int数字
     */
    public static int checkUserInput(String errorMsg){
        Scanner userInputBuffer = null;
        int buffer;
        while (true){
            userInputBuffer = new Scanner(System.in);
            try{
                buffer = userInputBuffer.nextInt();
                return buffer;
            }catch (NumberFormatException error) {
                if(errorMsg!=null){
                    System.out.println(errorMsg);
                }
                continue;
            }
        }
    }


}

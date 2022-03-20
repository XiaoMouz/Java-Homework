package com.mou.util;

import java.util.ArrayList;

public class StringHandle {
    /**
     * 用于计算字符串内出现目标字符的次数
     * @param containString 需要匹配的字符串
     * @param target 需要对比的字符
     * @return 出现的次数,int类型,若是0则不存在
     */
    public static int stringCharContainTimes(String containString,char target){
        char[] containGroup = containString.toCharArray();
        int times = 0;
        for (int i = 0;i < containGroup.length;i++){
            if(containGroup[i] == target){
                times++;
            }
        }
        return times;
    }

    /**
     * 用于剪切一个字符串并存入一个字符串数组中
     * @param stdString 需要剪切的字符串
     * @param cutTarget 剪切分割关键字
     * @return 剪切后的字符串数组
     */
    public static ArrayList<String> cutString(String stdString,char cutTarget){
        ArrayList<String> strings = new ArrayList<>();
        int times =  stringCharContainTimes(stdString,cutTarget);
        //提请注意:每次for循环，在判定大小时，若大小判定使用的是函数，则每次都会向函数请求一次值，由于stdString每次会被剪辑&替换，因此次数会少于预定次数，所以将其单独储存为妙
        for(int i = 0;i < times;i++){
            strings.add(stdString.substring(0,stdString.indexOf(cutTarget)));
            stdString = stdString.substring(stdString.indexOf(cutTarget)+1);
        }
        strings.add(stdString);
        return strings;
    }

    /**
     * 用于判断字符串是否能够转换为double类型整数，并且是否会大于或小于给定的数值
     * @param buffer 需要判断的字符串
     * @param max 最大数
     * @param min 最小数
     * @return 若符合条件并且在范围内则返回true，否则为false
     */
    public static boolean checkNumber(String buffer,double max,double min) {
        double transGo;
        try { //判断输入是否符合数字条件
            transGo = Double.parseDouble(buffer);
        } catch (NumberFormatException error) {
            return false;
        }
        //大小判断
        return transGo >= min && transGo <= max;
    }

    /**
     * 将字符串转换为Double类型，如遇到问题则会返回0
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
     * 用于在该类内检查性别字符串合法性的方法
     * @param handleString 需要配对的字符串
     * @return 是否符合匹配条件
     */
    public static boolean genderChecker(String handleString){
        switch (handleString) { //性别输入识别
            case "男", "Man", "man", "MAN", "Male", "MALE", "女", "woman", "Woman", "WOMAN", "female", "Female", "FEMALE" -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

}

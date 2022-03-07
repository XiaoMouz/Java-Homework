package com.xmz.util;

import java.util.ArrayList;
import java.util.List;

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
        for(int i = 0;i < stringCharContainTimes(stdString,cutTarget);i++){
            strings.add(stdString.substring(0,stdString.indexOf(cutTarget)-1));
            stdString = stdString.substring(stdString.indexOf(cutTarget)+1);
        }
        return strings;
    }
}

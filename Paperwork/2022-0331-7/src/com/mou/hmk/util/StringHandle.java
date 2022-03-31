package com.mou.hmk.util;

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
    public static String[] cutString(String stdString, char cutTarget){
        ArrayList<String> strings = new ArrayList<>();
        int times =  stringCharContainTimes(stdString,cutTarget);
        if (times==0){
            String[] strs = new String[1];
            strs[0] = stdString;
            return strs;
        }
        //提请注意:每次for循环，在判定大小时，若大小判定使用的是函数，则每次都会向函数请求一次值，由于stdString每次会被剪辑&替换，因此次数会少于预定次数，所以将其单独储存为妙
        for(int i = 0;i < times;i++){
            strings.add(stdString.substring(0,stdString.indexOf(cutTarget)));
            stdString = stdString.substring(stdString.indexOf(cutTarget)+1);
        }
        strings.add(stdString);
        return (String[])strings.toArray(new String[0]);
    }

    /**
     * 将字符串转换为Double类型，如遇到问题则会返回0
     * @param buffer 需要转换的字符串
     * @return 转换后的字符串
     */
    public static Double returnNumber(String buffer) {
        double transGo;
        try { //判断输入是否符合数字条件
            transGo = Double.parseDouble(buffer);
        } catch (NumberFormatException error) {
            return 0.0;
        }
        //大小判断
        return transGo;
    }

}

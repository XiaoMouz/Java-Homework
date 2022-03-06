package com.xmz.base.util;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InfomationInput {
    /**
     * 
     * @param buffer
     * @param max
     * @param min
     * @return
     */
    private static boolean checkNumber(String buffer,int max,int min) {
        int transGo;
        try { //判断输入是否符合数字条件
            transGo = Integer.parseInt(buffer);
        } catch (NumberFormatException error) {
            return false;
        }
        //大小判断
        return transGo >= min && transGo <= max;
    }

    //用于检查double类型的数字是否正常，返回布尔值，max对应可接收值，min对应最小值
    private static boolean checkNumber(String buffer,double max,double min) {
        double transGo;
        try { //判断输入是否符合数字条件
            transGo = Double.parseDouble(buffer);
        } catch (NumberFormatException error) {
            return false;
        }
        //大小判断
        return transGo >= min && transGo <= max;
    }

//    public static boolean ThisIsNumber(String buffer) {
//        int transGo;
//        while (true) {
//            try { //判断输入是否符合数字条件
//                transGo = Integer.parseInt(buffer);
//                return true;
//            } catch (NumberFormatException ex) {
//                return false;
//            }
//        }
//    }


    //用于处理用户信息接收
    public static HashMap getUserInfo(HashMap in){
        String nameRegular = "^[\\u4e00-\\u9fa5.·\\u36c3\\u4DAE]{2,6}$";//中文姓名匹配用的正则表达式
        String phoneNumberRegular = "^1[3|4|5|7|8][0-9]\\d{4,8}$";//
        String fullNumberRegular = "[0-9]+";
        Scanner input = new Scanner(System.in);
        HashMap<String,String> newTable = new HashMap< String,String>();
        newTable.putAll(in);
        String buffer;
        for(String i : newTable.keySet()) {
            buffer = null;
            System.out.println("现在请输入您的" + i);

            //执行各项判断
            if (Objects.equals(i, "姓名")) { //姓名键入
                while (true) {
                    buffer = input.nextLine();
                    if (Pattern.matches(nameRegular,buffer)) { //姓名合理性校验
                        newTable.replace(i, buffer);
                        break;
                    }
                    System.out.println("你的名字必须是两个字符以上五个字符以下，并且必须是中文");
                    continue;
                }

            } else if (Objects.equals(i, "学号")) { //学号收集
                while(true){
                    buffer = input.nextLine();
                    if(checkNumber(buffer,99999999,10000000)){
                        newTable.replace(i,buffer);
                        break;
                    }
                    System.out.println("你的学号必须是八位数");
                }
            } else if (Objects.equals(i, "年龄")) { //年龄收集
                while (true) {
                    buffer = input.nextLine();
                    if(checkNumber(buffer,200,3)){//年龄最高200岁最低3岁
                        newTable.replace(i,buffer);
                        break;
                    }else{
                        System.out.println("你的年龄不符合逻辑，请重新输入");
                    }
                }
            } else if (Objects.equals(i, "性别")) {//性别收集
                boolean Leave = true;
                while (Leave) { //shit code
                    buffer = input.nextLine();
                    switch (buffer) { //性别输入识别
                        case "男", "Man", "man", "MAN", "Male", "MALE" -> {
                            newTable.replace(i, "男");
                            Leave = false;
                        }
                        case "女", "woman", "Woman", "WOMAN", "female", "Female", "FEMALE" -> {
                            newTable.replace(i, "女");
                            Leave = false;
                        }
                        default -> System.out.println("不符合要求，请重新输入");
                    }
                }
            } else if (Objects.equals(i, "QQ")) {//QQ收集
                while(true){
                    buffer = input.nextLine();
                    if(buffer.length()>5&&buffer.length()<14&&Pattern.matches(fullNumberRegular,buffer)){
                        newTable.replace(i,buffer);
                        break;
                    }else{
                        System.out.println("你的输入不合理，请重新输入");
                    }
                }


            }else if(Objects.equals(i,"手机号")){//手机号收集
                while (true){
                    buffer = input.nextLine();
                    if(buffer.length()==11&&Pattern.matches(phoneNumberRegular,buffer)){
                        newTable.replace(i,buffer);
                        break;
                    }else{
                        System.out.println("手机号不正确，请重新输入");
                    }
                }
            }else if(Objects.equals(i,"身高")){//身高收集
                System.out.print("以cm计算:");
                while(true){
                    buffer = input.nextLine();
                    if(checkNumber(buffer,250,30)){
                        newTable.replace(i,buffer);
                        break;
                    }else{
                        System.out.println("输入不合理，请重新输入");
                    }
                }
            }else if(Objects.equals(i,"体重")){//体重收集
                System.out.print("以kg计算:");
                while(true){
                    buffer = input.nextLine();
                    if(checkNumber(buffer,300,1.5)){
                        newTable.replace(i,buffer);
                        break;
                    }else{
                        System.out.println("输入不合理，请重新输入");
                    }
                }
            }else{
                newTable.replace(i,input.nextLine());
            }
        }

        return newTable;
    }

}

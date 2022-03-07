package com.xmz.base.util;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InformationInput {
    /**
     * 用于判断字符串是否能够转换为int类型整数，并且是否会大于或小于给定的数值
     * @param buffer 用于判断的整数
     * @param max 最大数
     * @param min 最小数
     * @return 若符合条件并且在范围内则返回true，否则为false
     */
    public static boolean checkNumber(String buffer,int max,int min) {
        int transGo;
        try { //判断输入是否符合数字条件
            transGo = Integer.parseInt(buffer);
        } catch (NumberFormatException error) {
            return false;
        }
        //大小判断
        return transGo >= min && transGo <= max;
    }

    /**
     * 用于判断字符串是否能够转换为double类型整数，并且是否会大于或小于给定的数值
     * @param buffer 用于判断的整数
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
     * 用于在该类内检查性别字符串合法性的方法
     * @param handleString 需要配对的字符串
     * @return 是否符合匹配条件
     */
    private static boolean genderChecker(String handleString){
        switch (handleString) { //性别输入识别
            case "男", "Man", "man", "MAN", "Male", "MALE", "女", "woman", "Woman", "WOMAN", "female", "Female", "FEMALE" -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    /**
     * 能够处理基础信息的通用方法，能够适配姓名、学号、手机号、QQ号、性别、身高与体重，并且会返回符合哪个条件(注意，体重与身高在此处已被限定)
     * @param stdString 需要用于检查的字符串
     * @param mode 选择需要用于检查的模式
     * @return 返回0则代表不符合任意条件，返回1符合中文名称，返回2符合学号，返回3符合QQ号，返回4符合手机号，返回5符合性别，返回6符合身高，返回7符合体重
     */
    public static int userInformationHandle(String stdString,InformationHandleMode mode){
        //会用到的正则表达式
        String nameRegular = "^[\\u4e00-\\u9fa5.·\\u36c3\\u4DAE]{2,6}$";
        String phoneNumberRegular = "^1[3|4|5|7|8][0-9]\\d{4,8}$";
        String fullNumberRegular = "[0-9]+";

        if ((mode==InformationHandleMode.NAME||mode==InformationHandleMode.DEFAULT)&&stdString.matches(nameRegular)){
            return 1;
        }else if ((mode==InformationHandleMode.ID||mode==InformationHandleMode.DEFAULT)&&checkNumber(stdString,99999999,10000000)){
            return 2;
        }else if ((mode==InformationHandleMode.QQ||mode==InformationHandleMode.DEFAULT)&&(stdString.length()>5&&stdString.length()<14&&stdString.matches(fullNumberRegular))){
            return 3;
        }else if ((mode==InformationHandleMode.TELEPHONE||mode==InformationHandleMode.DEFAULT)&&stdString.matches(phoneNumberRegular)){
            return 4;
        }else if ((mode==InformationHandleMode.GENDER||mode==InformationHandleMode.DEFAULT)&&genderChecker(stdString)) {
            return 5;
        }else if((mode==InformationHandleMode.HEIGHT||mode==InformationHandleMode.DEFAULT)&&checkNumber(stdString,250,5)){
            return 6;
        }else if((mode==InformationHandleMode.WIDTH||mode==InformationHandleMode.DEFAULT)&&checkNumber(stdString,300,1.5)){
            return 7;
        }else{
            return 0;
        }
    }

    //处于v1版本的接受并处理用户信息方法，现已停用
//    private static HashMap getUserInfo(HashMap in){
//        String nameRegular = "^[\\u4e00-\\u9fa5.·\\u36c3\\u4DAE]{2,6}$";//中文姓名匹配用的正则表达式
//        String phoneNumberRegular = "^1[3|4|5|7|8][0-9]\\d{4,8}$";//
//        String fullNumberRegular = "[0-9]+";
//        Scanner input = new Scanner(System.in);
//        HashMap<String,String> newTable = new HashMap< String,String>();
//        newTable.putAll(in);
//        String buffer;
//        for(String i : newTable.keySet()) {
//            buffer = null;
//            System.out.println("现在请输入您的" + i);
//
//            //执行各项判断
//            if (Objects.equals(i, "姓名")) { //姓名键入
//                while (true) {
//                    buffer = input.nextLine();
//                    if (Pattern.matches(nameRegular,buffer)) { //姓名合理性校验
//                        newTable.replace(i, buffer);
//                        break;
//                    }
//                    System.out.println("你的名字必须是两个字符以上五个字符以下，并且必须是中文");
//                    continue;
//                }
//
//            } else if (Objects.equals(i, "学号")) { //学号收集
//                while(true){
//                    buffer = input.nextLine();
//                    if(checkNumber(buffer,99999999,10000000)){
//                        newTable.replace(i,buffer);
//                        break;
//                    }
//                    System.out.println("你的学号必须是八位数");
//                }
//            } else if (Objects.equals(i, "年龄")) { //年龄收集
//                while (true) {
//                    buffer = input.nextLine();
//                    if(checkNumber(buffer,200,3)){//年龄最高200岁最低3岁
//                        newTable.replace(i,buffer);
//                        break;
//                    }else{
//                        System.out.println("你的年龄不符合逻辑，请重新输入");
//                    }
//                }
//            } else if (Objects.equals(i, "性别")) {//性别收集
//                boolean Leave = true;
//                while (Leave) { //shit code
//                    buffer = input.nextLine();
//                    switch (buffer) { //性别输入识别
//                        case "男", "Man", "man", "MAN", "Male", "MALE" -> {
//                            newTable.replace(i, "男");
//                            Leave = false;
//                        }
//                        case "女", "woman", "Woman", "WOMAN", "female", "Female", "FEMALE" -> {
//                            newTable.replace(i, "女");
//                            Leave = false;
//                        }
//                        default -> System.out.println("不符合要求，请重新输入");
//                    }
//                }
//            } else if (Objects.equals(i, "QQ")) {//QQ收集
//                while(true){
//                    buffer = input.nextLine();
//                    if(buffer.length()>5&&buffer.length()<14&&Pattern.matches(fullNumberRegular,buffer)){
//                        newTable.replace(i,buffer);
//                        break;
//                    }else{
//                        System.out.println("你的输入不合理，请重新输入");
//                    }
//                }
//
//
//            }else if(Objects.equals(i,"手机号")){//手机号收集
//                while (true){
//                    buffer = input.nextLine();
//                    if(buffer.length()==11&&Pattern.matches(phoneNumberRegular,buffer)){
//                        newTable.replace(i,buffer);
//                        break;
//                    }else{
//                        System.out.println("手机号不正确，请重新输入");
//                    }
//                }
//            }else if(Objects.equals(i,"身高")){//身高收集
//                System.out.print("以cm计算:");
//                while(true){
//                    buffer = input.nextLine();
//                    if(checkNumber(buffer,250,30)){
//                        newTable.replace(i,buffer);
//                        break;
//                    }else{
//                        System.out.println("输入不合理，请重新输入");
//                    }
//                }
//            }else if(Objects.equals(i,"体重")){//体重收集
//                System.out.print("以kg计算:");
//                while(true){
//                    buffer = input.nextLine();
//                    if(checkNumber(buffer,300,1.5)){
//                        newTable.replace(i,buffer);
//                        break;
//                    }else{
//                        System.out.println("输入不合理，请重新输入");
//                    }
//                }
//            }else{
//                newTable.replace(i,input.nextLine());
//            }
//        }
//
//        return newTable;
//    }

}

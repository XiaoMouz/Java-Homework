package com.xmz.main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class GetInfo {

    public static void clearCMD(){
        try {
            Runtime.getRuntime().exec("cmd.exe /c cls");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    public static HashMap getUserInfo(HashMap in){
        Scanner input = new Scanner(System.in);
        HashMap<String,String> newTable = new HashMap<String,String>();
        newTable.putAll(in);
        String buffer;
        for(String i : newTable.keySet()) {
            clearCMD();
            buffer = null;
            System.out.println("现在请输入您的" + i);

            //执行各项判断
            if (Objects.equals(i, "姓名")) { //姓名键入
                while (true) {
                    buffer = input.nextLine();
                    if (buffer.length() > 5||buffer.length() < 2) { //姓名合理性校验
                        System.out.println("你的名字必须是两个字符以上五个字符以下");
                        continue;
                    }
                    newTable.replace(i, buffer);
                    break;
                }

            } else if (Objects.equals(i, "学号")) { //学号输入
                while(true){
                    buffer = input.nextLine();
                    if(checkNumber(buffer,99999999,10000000)){
                        newTable.replace(i,buffer);
                        break;
                    }
                    System.out.println("你的学号必须是八位数");
                }
            } else if (Objects.equals(i, "年龄")) { //年龄输入
                while (true) {
                    buffer = input.nextLine();
                    if(checkNumber(buffer,200,3)){//年龄最高200岁最低3岁
                        newTable.replace(i,buffer);
                        break;
                    }else{
                        System.out.println("你的年龄不符合逻辑，请重新输入");
                    }
                }
            } else if (Objects.equals(i, "性别")) {
                boolean Leave = true;
                while (Leave) { //shit code
                    buffer = input.nextLine();
                    switch (buffer) {
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
            } else if (Objects.equals(i, "QQ")) {
                while(true){
                    buffer = input.nextLine();
                    if(buffer.length()>5&&buffer.length()<14){
                        newTable.replace(i,buffer);
                        break;
                    }else{
                        System.out.println("你的输入不合理，请重新输入");
                    }
                }


            }else if(Objects.equals(i,"手机号")){
                while (true){
                    buffer = input.nextLine();
                    if(buffer.length()==11){
                        newTable.replace(i,buffer);
                        break;
                    }else{
                        System.out.println("手机号不正确，请重新输入");
                    }
                }
            }else if(Objects.equals(i,"身高")){
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
            }else if(Objects.equals(i,"体重")){
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

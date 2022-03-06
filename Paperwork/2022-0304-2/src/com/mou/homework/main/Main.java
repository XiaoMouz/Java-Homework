package com.mou.main;

import com.mou.util.GetInfo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        String name = GetInfo.inputStr("请输入名称","[\\u4E00-\\u9FA5]{2,4}");
//        String id = GetInfo.inputStr("请输入学号","[0-9]{8}");
//        String gender = GetInfo.inputStr("请输入性别","男|女");
//        int age = GetInfo.inputNumber("请输入年龄",3,200);
//        Double height = GetInfo.inputNumber("请输入身高(以cm计算)",50.0,280.0);
//
//        System.out.println("姓名"+name+"学号"+id+"性别"+gender+"年龄"+age+"身高"+height);

        int students = GetInfo.inputNumber("请输入你要录入的学生数量",1,100);
        int counts = GetInfo.inputNumber("请输入你要录入的成绩数量",1,9);

        ArrayList<ArrayList<Double>> studentCount = GetInfo.inputAchievement(counts,students,120,0);
        ArrayList<Double> buffer = new ArrayList<>();

        int nowStudent = 1;
        int nowAc = 1;
        for(ArrayList i:studentCount){
            assert buffer != null;
            buffer.addAll(i);
            System.out.println("现在是"+nowStudent+"学生的成绩");
            for(Double j:buffer){
                System.out.print(j);
            }
            nowStudent++;
            buffer=null;
        }

    }
}

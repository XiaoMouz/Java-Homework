package com.mou.homework.main;

import com.mou.homework.util.GetAchievement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int students = GetAchievement.inputNumber("请输入你要录入的学生数量",1,100);
        int counts = GetAchievement.inputNumber("请输入你要录入的成绩数量",1,9);
        double aMax = GetAchievement.inputNumber("输入单科最大成绩",1,200);
        double aMin = GetAchievement.inputNumber("输入单科最小成绩",-1,200);

        ArrayList<ArrayList<Double>> studentCount = GetAchievement.inputAchievement(students,counts,aMax,aMin);

        for(int i = 0;i<studentCount.size();i++){
            for (int j = 0;j<(studentCount.get(i)).size();j++){
                System.out.println("现在是是第"+(i+1)+"位同学的第"+(j+1)+"科成绩，他的成绩为"+(studentCount.get(i)).get(j)+"分");
            }
        }
    }
}

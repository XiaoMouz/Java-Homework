package com.xmz.main;

import com.xmz.base.Information;
import com.xmz.base.util.AchievementInput;
import com.xmz.util.StringHandle;

public class AppMain {
    //example:小莫|软件3班|男|21120342|13026201164|172cm|60kg
    //achievement example:any;
    public static void main(String[] args) {
        Information mainUser = new Information();
        System.out.println("请输入你的基础信息(姓名、班级、性别、学号、手机号、QQ、身高与体重");
        mainUser = Information.collectBasicInformationFromConsole("以|分割，并且身高请以cm计算，体重以kg计算");
        printfInfo(mainUser);
        mainUser.achievementCollect(120.0,0.0);
        printfInfo(mainUser);
        System.out.print("成绩:\n");
        System.out.print("C语言\t|Java\t|MySQL\t|Web\t|总分\t平均分\t\n");
        for(int i=0;i<(mainUser.achievement).length-1;i++){
            System.out.print(mainUser.achievement[i]+"\t|");
            mainUser.sum+=mainUser.achievement[i];
        }
        mainUser.sum+=mainUser.achievement[mainUser.achievement.length-1];
        mainUser.avg=mainUser.sum/(mainUser.achievement).length;
        System.out.print((mainUser.achievement[mainUser.achievement.length-1])+"\t|"+ mainUser.sum+"\t|"+ mainUser.avg);

    }

    public static void printfInfo(Information mainUser){
        System.out.print("姓名\t|班级\t|性别\t|学号\t\t|手机号\t\t\t|身高\t|体重\n");
        System.out.print(mainUser.name+"\t|"+mainUser._class+"\t|"+mainUser.gender+"\t\t|"+mainUser.id+"\t|"+mainUser.telePhone+"\t|"+mainUser.height+"\t|"+ mainUser.width+"\t\n");
    }
}

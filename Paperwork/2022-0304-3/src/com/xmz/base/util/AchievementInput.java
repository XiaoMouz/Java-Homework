package com.xmz.base.util;

import com.xmz.base.Information;
import com.xmz.util.StringHandle;

import java.util.Scanner;

public class AchievementInput {

    public static Double[] achievementHandle(double achievementMax,double achievementMin){
        Double[] achievementGroup = new Double[4];
        String msg;
        for (int i=0;i<achievementGroup.length;i++){
            if(i==0){
                msg="C语言";
            }else if(i==1){
                msg="Java";
            }else if(i==2){
                msg="MySQL";
            }else {
                msg="Web";
            }
            System.out.println("现在输入您的"+msg+"成绩");
            achievementGroup[i] = achievementGet(achievementMax,achievementMin);
        }
        return achievementGroup;
    }

    private static Double achievementGet(double max,double min){
        Scanner in;
        String buffer;
        while(true){
            in = new Scanner(System.in);
            buffer = in.next();
            if(StringHandle.checkNumber(buffer,max,min)){
                return StringHandle.returnNumber(buffer);
            }else{
                System.out.println("错误，请重新输入");
            }
        }
    }

    public static Double[] reInputAchievement(Double[] achievementGroup,AchievementCourse mode,double achievementMax,double achievementMin){
        switch (mode){
            case C:achievementGroup[0]=achievementGet(achievementMax,achievementMin);return achievementGroup;
            case JAVA:achievementGroup[1]=achievementGet(achievementMax,achievementMin);return achievementGroup;
            case MYSQL:achievementGroup[2]=achievementGet(achievementMax,achievementMin);return achievementGroup;
            case WEB:achievementGroup[3]=achievementGet(achievementMax,achievementMin);return achievementGroup;
            default:return achievementGroup;
        }
    }
}

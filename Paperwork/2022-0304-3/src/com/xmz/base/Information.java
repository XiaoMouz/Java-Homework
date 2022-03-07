package com.xmz.base;

import com.xmz.util.StringHandle;

import java.util.ArrayList;
import java.util.Scanner;

public class Information{
    public String name,_class,QQ,phoneNumber,id,height,width;
    public Double[] achievement;

    public Information CollectBasicInformationFromConsole(String tips){
        Information doneInfo = new Information();
        //[x]TODO:打印提示信息至控制台并且收集用户输入
        System.out.println(tips);
        Scanner in = new Scanner(System.in);
        String getUserInput = in.nextLine();

        //[x]TODO:对字符串进行处理，存入Information类
        ArrayList<String> userInfoList = StringHandle.CutString(getUserInput,',');
        char[] arrayListMatchChar = {',','|','，',' ','\t'};//用于切割&比对的字符串
        for(int i = 0;i<arrayListMatchChar.length;i++){
            if(userInfoList.isEmpty()){
                userInfoList = StringHandle.CutString(getUserInput,arrayListMatchChar[i]);
                continue;
            }else{
                break;
            }
            System.out.println("Error,break out [code:01]");
            return null;
        }
        //[ ]TODO:存入Information对象，判断是否合法，如不合法请求重写该字段直到合法为止
        for (int i = 0;i < userInfoList.size();i++){

        }
        //
        return
    }
}

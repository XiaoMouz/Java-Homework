package com.xmz.main;

import java.util.HashMap;
import java.util.Scanner;

import static com.xmz.main.GetInfo.GetUserInfo;

public class AppMain {
    public static void main(String[] args){
        HashMap<String,String> info = new HashMap<String,String>();
        Scanner input = new Scanner(System.in);
        QuickReady.Intialize(info);
        info = GetUserInfo(info);

        for(String i:info.keySet()){
            System.out.println("您的"+i+"是"+info.get(i));
        }
    }
}

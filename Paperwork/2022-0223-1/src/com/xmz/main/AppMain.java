package com.xmz.main;

import java.util.HashMap;
import java.util.Scanner;


public class AppMain {
    public static void main(String[] args){
        HashMap<String,String> info = new HashMap<String,String>();//用于预备用于储存的HashMap对象
        QuickReady.Intialize(info); //初始化内部值
        info = GetInfo.getUserInfo(info); //获取信息

        //打印各项信息
        for(String i:info.keySet()){
            System.out.println("您的"+i+"是"+info.get(i));
        }
    }
}

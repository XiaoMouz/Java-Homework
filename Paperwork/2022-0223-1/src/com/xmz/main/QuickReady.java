package com.xmz.main;

import java.util.HashMap;

public class QuickReady {

    public static HashMap Intialize(HashMap in){
        if(in.size()!=0){
            in.clear();
        }
        in.put("姓名",null);
        in.put("学号",null);
        in.put("年龄",null);
        in.put("性别",null);
        in.put("班级",null);
        in.put("QQ",null);
        in.put("手机号",null);
        in.put("身高",null);
        in.put("体重",null);
        return in;
    }
}

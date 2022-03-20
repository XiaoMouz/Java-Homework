package com.mou.base;

import com.mou.base.util.InformationHandleMode;
import com.mou.base.util.InformationInput;
import com.mou.util.NumberHandle;
import com.mou.util.StringHandle;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 本类拥有8个可控制字符串成员，对应学生基础信息|1个双精度数组成员，对应各科成绩|2个双精度数成员，对应总数和平均数
 * 其中字符串成员只有较不完善的写入控制
 */
public class Person{
    public String name,telePhone,id,gender,height,width,_class;
    int age;

    /**
     * 通常情况下这些内容都为空，成绩总分与平均分是0
     */
    public Person() {
        this.name = null;
        //this.QQ = null;
        this.telePhone = null;
        this.gender = null;
        this.height = null;
        this.width = null;
        this._class = null;
        this.age=0;
    }

    /**
     * 用于检查该对象是否还有空的字符串成员，若有则返回对应的数字，只会检查一次，若有多个建议反复调用8次来确保所有字符串成员已有相应信息
     * @param needCheck 需要检查的Information对象
     * @return 返回0则代表完全通过，返回1表示名称有误，返回2学号有误，返回3年龄号有误，返回4手机号有误，返回5性别有误，返回6身高有误，返回7体重有误
     */
    private static int checkInformationContact(Person needCheck){
        if(needCheck.name==null){
            return 1;
        }else if(needCheck.id==null){
            return 2;
        }else if(needCheck.age==0){
            return 3;
        }
        else if(needCheck.telePhone==null){
            return 4;
        }else if(needCheck.gender==null){
            return 5;
        }else if(needCheck.height==null){
            return 6;
        }else if(needCheck.width==null){
            return 7;
        }else{
            return 0;
        }
    }

    /**
     * 用于在第一次字符串收集未能成功重新录入的方法
     * @param mode 选择需要覆写的内容
     * @return 符合相应条件的字符串
     */
    private static String reInputInfo(InformationHandleMode mode){
        Scanner in = new Scanner(System.in);
        String msg,buffer;
        int modeCheck;
        switch (mode){
            case NAME -> {
                msg="名称";
                modeCheck = 1;
            }
            case ID -> {
                msg="学号";
                modeCheck=2;
            }
            case AGE -> {
               msg="年龄";
                modeCheck=3;
            }
            case TELEPHONE -> {
                msg="手机号";
                modeCheck=4;
            }
            case GENDER -> {
                msg = "性别";
                modeCheck=5;
            }
            case HEIGHT -> {
                msg = "身高";
                modeCheck=6;
            }
            case WIDTH -> {
                msg = "体重";
                modeCheck=7;
            }
            default -> {
                msg = "未知信息";
                modeCheck=0;
            }
        }
        while(true){
            System.out.println("请重新输入您的"+msg);
            buffer = in.nextLine();
            if(InformationInput.userInformationHandle(buffer,mode)==modeCheck){
                return buffer;
            }else{
                System.out.println("输入有误请重输");
            }
        }
    }

    /**
     * 基础信息接受，并且禁止集合为空
     * @param tips 提示
     * @return 包含基础信息的集合
     */
    private static ArrayList<String> basicInputInfo(String tips){
        System.out.println(tips);
        Scanner in ;
        String getUserInput;

        //对字符串进行处理，存入Information类
        ArrayList<String> userInfoList = new ArrayList<>();//用于存储切割后的字符串
        char[] arrayListMatchChar = {',','|','，',' ','\t'};//用于切割&比对的字符串
        //此循环用于循环使用arrayListMatchChar数组内的切割分析元素来校验，倘若接收过来的集合非空则跳过

        while(true){
            in = new Scanner(System.in);
            getUserInput = in.nextLine();
            userInfoList = StringHandle.cutString(getUserInput,'|');
            for (char c : arrayListMatchChar) {
                if (userInfoList.size()>8) {
                    userInfoList = StringHandle.cutString(getUserInput, c);
                } else {
                    break;
                }
            }
            if(userInfoList.isEmpty()){
                System.out.println("请重新输入信息");
            }else{
                break;
            }
        }
        return userInfoList;
    }

    /**
     * 用于收集基础数据(姓名，手机号等内容)的方法，只需要传入合适的提示
     * @param tips 录入提示
     * @return 通过所有字符串校验，基础信息已补充的Information对象
     */
    public static Person collectBasicInformationFromConsole(String tips){
        Person doneInfo = new Person();
        //打印提示信息至控制台并且收集用户输入
        ArrayList<String> userInfoList = basicInputInfo(tips);

        //存入Information对象，判断是否合法，如不合法请求重写该字段直到合法为止
        //userInformationHandle的return:返回0则代表不符合任意条件，返回1符合中文名称，返回2符合学号，返回3符合QQ号，返回4符合手机号，返回5符合性别，返回6符合身高，返回7符合体重
        for (String s : userInfoList) {
            switch (InformationInput.userInformationHandle(s, InformationHandleMode.DEFAULT)) {
                case 1 -> doneInfo.name = s;
                case 2 -> doneInfo.id = s;
                case 3 -> doneInfo.age = StringHandle.returnNumber(s);
                case 4 -> doneInfo.telePhone = s;
                case 5 -> doneInfo.gender = s;
                case 6 -> doneInfo.height = s;
                case 7 -> doneInfo.width = s;
                default -> doneInfo._class = s;
            }
        }
        //出现不正确或空数据时进行的覆写操作
        for(int i = 0;i < 8;i++){
            int code = checkInformationContact(doneInfo);
            if(code!=0){
                switch (code){
                    case 1 -> doneInfo.name = reInputInfo(InformationHandleMode.NAME);
                    case 2 -> doneInfo.id = reInputInfo(InformationHandleMode.ID);
                    case 3 -> doneInfo.age = StringHandle.returnNumber(reInputInfo(InformationHandleMode.AGE));
                    case 4 -> doneInfo.telePhone = reInputInfo(InformationHandleMode.TELEPHONE);
                    case 5 -> doneInfo.gender = reInputInfo(InformationHandleMode.GENDER);
                    case 6 -> doneInfo.height = reInputInfo(InformationHandleMode.HEIGHT);
                    case 7 -> doneInfo.width = reInputInfo(InformationHandleMode.WIDTH);
                }
            }
        }
        return doneInfo;
    }

    public void eat(){
        System.out.println(this.name+"在吃东西");
    }

    public void drink(){
        System.out.println(this.name+"在喝饮料");
    }

    public void play(){
        System.out.println(this.name+"在玩东西");
    }

    public void whoAmI(){
        System.out.println("我是"+ this.name+"，今年"+ this.age+"岁，是"+ this.gender+"生");
    }
}

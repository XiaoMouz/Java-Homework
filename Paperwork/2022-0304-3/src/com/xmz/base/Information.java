package com.xmz.base;

import com.xmz.base.util.InformationHandleMode;
import com.xmz.base.util.InformationInput;
import com.xmz.util.StringHandle;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 本类拥有8个可控制字符串成员，对应学生基础信息|1个双精度数组成员，对应各科成绩|2个双精度数成员，对应总数和平均数
 * 其中字符串成员只有较不完善的写入控制
 */
public class Information{
    public String name,QQ,telePhone,id,gender,height,width,_class;
    public Double[] achievement;
    public double sum,avg;

    public Information() {
        this.name = null;
        this.QQ = null;
        this.telePhone = null;
        this.gender = null;
        this.height = null;
        this.width = null;
        this._class = null;
        this.sum = 0;
        this.avg = 0;
    }

    /**
     * 用于检查该对象是否还有空的字符串成员，若有则返回对应的数字，只会检查一次，若有多个建议反复调用8次来确保所有字符串成员已有相应信息
     * @param needCheck 需要检查的Information对象
     * @return 返回0则代表完全通过，返回1表示名称有误，返回2学号有误，返回3QQ号有误，返回4手机号有误，返回5性别有误，返回6身高有误，返回7体重有误
     */
    private int checkInformationContact(Information needCheck){
        if(needCheck.name==null){
            return 1;
        }else if(needCheck.id==null){
            return 2;
        }else if(needCheck.QQ==null){
            return 3;
        }else if(needCheck.telePhone==null){
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
    private String reInputInfo(InformationHandleMode mode){
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
            case QQ -> {
                msg="QQ";
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
                msg = "未知信息(或许是成绩)";
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
     * 用于收集基础数据(姓名，手机号等内容)的方法，只需要传入合适的提示
     * @param tips 录入提示
     * @return 通过所有字符串校验，基础信息已补充的Information对象
     */
    public Information CollectBasicInformationFromConsole(String tips){
        Information doneInfo = new Information();
        //[x]TODO:打印提示信息至控制台并且收集用户输入
        System.out.println(tips);
        Scanner in = new Scanner(System.in);
        String getUserInput = in.nextLine();

        //[x]TODO:对字符串进行处理，存入Information类
        ArrayList<String> userInfoList = StringHandle.cutString(getUserInput,',');//用于存储切割后的字符串

        char[] arrayListMatchChar = {',','|','，',' ','\t'};//用于切割&比对的字符串
        //此循环用于循环使用arrayListMatchChar数组内的切割分析元素来校验，倘若接收过来的集合非空则跳过
        for(int i = 0;i<arrayListMatchChar.length;i++){
            if(userInfoList.isEmpty()){
                userInfoList = StringHandle.cutString(getUserInput,arrayListMatchChar[i]);
            }else{
                break;
            }
        }
        //判断上轮for循环是否成功收集到数据
        if(userInfoList.isEmpty()){
            System.out.println("error");
            return null;
        }
        //[x]TODO:存入Information对象，判断是否合法，如不合法请求重写该字段直到合法为止
        //userInformationHandle的return:返回0则代表不符合任意条件，返回1符合中文名称，返回2符合学号，返回3符合QQ号，返回4符合手机号，返回5符合性别，返回6符合身高，返回7符合体重
        for (int i = 0;i < userInfoList.size();i++){
            switch (InformationInput.userInformationHandle(userInfoList.get(i), InformationHandleMode.DEFAULT)) {
                case 1 -> doneInfo.name = userInfoList.get(i);
                case 2 -> doneInfo.id = userInfoList.get(i);
                case 3 -> doneInfo.QQ = userInfoList.get(i);
                case 4 -> doneInfo.telePhone = userInfoList.get(i);
                case 5 -> doneInfo.gender = userInfoList.get(i);
                case 6 -> doneInfo.height = userInfoList.get(i);
                case 7 -> doneInfo.width = userInfoList.get(i);
                default -> doneInfo._class = userInfoList.get(i);
            }
        }
        //出现不正确或空数据时进行的覆写操作
        for(int i = 0;i < 8;i++){
            int code = checkInformationContact(doneInfo);
            if(code!=0){
                switch (code){
                    case 1 -> doneInfo.name = reInputInfo(InformationHandleMode.NAME);
                    case 2 -> doneInfo.id = reInputInfo(InformationHandleMode.ID);
                    case 3 -> doneInfo.QQ = reInputInfo(InformationHandleMode.QQ);
                    case 4 -> doneInfo.telePhone = reInputInfo(InformationHandleMode.TELEPHONE);
                    case 5 -> doneInfo.gender = reInputInfo(InformationHandleMode.GENDER);
                    case 6 -> doneInfo.height = reInputInfo(InformationHandleMode.HEIGHT);
                    case 7 -> doneInfo.width = reInputInfo(InformationHandleMode.WIDTH);
                }
            }
        }
        return doneInfo;
    }


}
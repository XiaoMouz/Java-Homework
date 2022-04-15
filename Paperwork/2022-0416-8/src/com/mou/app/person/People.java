package com.mou.app.person;

import java.util.Objects;

public class People {
    private String name;
    private String phoneNumber;

    public void eat(){
        System.out.println(getName()+"喜欢吃东西");
    }
    public void eat(String food) {
        System.out.println(getName()+"喜欢吃"+food);
    }

    public String getName() {
        return Objects.requireNonNullElse(name, "未填写名称");
    }
    public void setName(String name) {
        if(name.matches("^[\\u4e00-\\u9fa5.·\\u36c3\\u4DAE]{2,6}$")){
            this.name = name;
        }else{
            this.name = null;
        }
    }

    public String getPhoneNumber() {
        return Objects.requireNonNullElse(this.phoneNumber, "未填写手机号");
    }
    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.matches("^1[3|4|5|7|8][0-9]\\d{4,8}$")){
            this.phoneNumber=phoneNumber;
        }else{
            this.phoneNumber=null;
        }
    }
}

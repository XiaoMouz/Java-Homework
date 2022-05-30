package com.mou.app.util.phone;

import com.mou.app.util.Phone;

public class NormalPhone extends Phone {
    public void calling(String phoneNumber){
        System.out.println("Calling "+phoneNumber);
    }
    public void sendMessage(String phoneNumber,String context){
        System.out.println("tel:"+phoneNumber+"\tcontext:"+context);
    }
    public void listenMusic(){
        System.out.println("listen");
    }
}

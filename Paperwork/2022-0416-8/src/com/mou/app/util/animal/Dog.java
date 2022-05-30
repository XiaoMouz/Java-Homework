package com.mou.app.util.animal;

import com.mou.app.util.Animal;

public class Dog extends Animal {
    public void eat(String food){
        System.out.println("eating"+food);
    }

    public void makeShit(){
        System.out.println("****");
    }

    public void eatShit(){
        System.out.println("oh,no");
    }
}

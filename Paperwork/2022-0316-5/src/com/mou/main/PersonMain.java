package com.mou.main;

import com.mou.base.Person;

public class PersonMain {
    public static void main(String[] args) {
        Person a = Person.collectBasicInformationFromConsole("输入信息，以|分割");
        a.eat();
        a.drink();
        a.play();
        a.whoAmI();
    }
}

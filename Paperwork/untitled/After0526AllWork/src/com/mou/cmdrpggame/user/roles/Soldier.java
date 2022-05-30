package com.mou.cmdrpggame.user.roles;

import java.util.Random;

public class Soldier extends Role{
    private int age;

    public Soldier(String playerName){
        this.setRoleTag(RoleTag.SOLDIER);
        this.setName(playerName);
        Random r = new Random();
        this.setAge(r.nextInt(60));
        this.setAtk(r.nextInt(5));
    }

    public Soldier(String playerName,int atk){
        this.setRoleTag(RoleTag.SOLDIER);
        this.setName(playerName);
        Random r = new Random();
        this.setAge(r.nextInt(60));
        try {
            setAtk(atk);
        }catch (Exception e){
            this.setAtk(r.nextInt(5));
        }
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

    public void printInfo(){
        System.out.println(getRoleTag()+"["+getName()+","+getAge()+"岁，攻击力"+getAtk()+"]");
    }
}

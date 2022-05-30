package com.mou.cmdrpggame.user.roles;

import java.util.Random;

public class Master extends Role{
    private int level;

    public Master(String playerName){
        this.setRoleTag(RoleTag.MASTER);
        this.setName(playerName);
        Random r = new Random();
        level = r.nextInt(5);
        updateAtk();
    }

    public Master(String playerName,int level){
        this.setRoleTag(RoleTag.MASTER);
        this.setName(playerName);
        try{
            this.level = level;
        }catch(Exception e){
            Random r = new Random();
            this.level = r.nextInt(5);
        }
        updateAtk();
    }

    @Override
    public void setAtk(int atk) {
        super.setAtk(atk*level);
    }
    public void updateAtk(){
        setAtk(5);
    }
    public int getLevel(){
        return level;
    }


    public void printInfo(){
        System.out.println(getRoleTag()+"["+getName()+","+getLevel()+"钱天师，攻击力"+getAtk()+"]");
    }

}

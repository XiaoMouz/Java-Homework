package com.mou.cmdrpggame.match;

import com.mou.cmdrpggame.user.roles.Master;
import com.mou.cmdrpggame.user.roles.Role;
import com.mou.cmdrpggame.user.roles.RoleTag;
import com.mou.cmdrpggame.user.roles.Soldier;

import java.util.function.Consumer;

public class Team {
    private Role[] member = new Role[6];
    public String name;
    private String creator;
    private int persons;
    private int masters;
    private int soldier;

    public Team(String teamName,Role creator) {
        this.name = teamName;
        this.creator = creator.getName();
        persons++;
        if (creator.getRoleTag() == RoleTag.MASTER) {
            masters++;
        } else {
            soldier++;
        }
        member[0]=creator;
    }

    public boolean addMember(Role player) {
        RoleTag playerTag = player.getRoleTag();
        if (playerTag == RoleTag.MASTER) {
            for (Role role : member) {
                try {
                    if (role.getRoleTag() == RoleTag.MASTER || this.masters >= 1) {
                        return false;
                    }
                }catch (Exception e){
                    continue;
                }
            }
            for (int i = 0; i < member.length; i++) {
                if (member[i] == null) {
                    member[i] = player;
                    masters++;
                    persons++;
                    return true;
                }
            }
        } else if (playerTag == RoleTag.SOLDIER) {
            for (int i = 0; i < member.length; i++) {
                if (member[i] == null&&soldier<=6) {
                    member[i] = player;
                    soldier++;
                    persons++;
                    return true;
                }
            }
        }
        return false;
    }

    public int teamAtkSum(){
        int atk = 0;
        for(Role role : member){
            if(role!=null){
                atk+= role.getAtk();
            }
        }
        return atk;
    }

    public void printTeamInfo(){
        StringBuilder str = new StringBuilder();
        str.append("????????????:").append(name).append(" | ");
        str.append("?????????:").append(creator).append(" | ");
        str.append("???????????????:").append(teamAtkSum()).append("\n");
        str.append("????????????:").append("\n");
        for (Role role : member){
            try{
                if(role.getRoleTag() == RoleTag.SOLDIER){
                    str.append("????????????:").append(role.getName()).append(" | ??????:" ).append(role.getRoleTag().toString()).append(" | ?????????:").append(role.getAtk()).append(" | ??????").append(((Soldier) role).getAge());
                }else if(role.getRoleTag() == RoleTag.MASTER){
                    str.append("????????????:").append(role.getName()).append(" | ??????:" ).append(role.getRoleTag().toString()).append(" | ?????????:").append(role.getAtk()).append(" | ??????").append(((Master) role).getLevel());
                }
                str.append("\n");
            }catch (Exception e){
                continue;
            }
        }
        System.out.print(str);
    }



}

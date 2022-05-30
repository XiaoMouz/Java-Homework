package com.mou.cmdrpggame.user.roles;

public class Role {
    //seed basic role information
    private RoleTag roleTag;
    private int atk;
    private String name;

    public RoleTag getRoleTag() {
        return roleTag;
    }
    public void setRoleTag(RoleTag roleTag) {
        this.roleTag = roleTag;
    }
    public int getAtk() {
        return atk;
    }
    public void setAtk(int atk) {
        this.atk = atk;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}

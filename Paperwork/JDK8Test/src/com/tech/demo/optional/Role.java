package com.tech.demo.optional;

public class Role {
    //seed basic role information
    private RoleTag roleTag;
    private int atk;
    private String name;

    public Role(RoleTag roleTag, int atk, String name) {
        this.roleTag = roleTag;
        this.atk = atk;
        this.name = name;
    }
    public Role(){};


    @Override
    public String toString() {
        return "Role{" +
                "roleTag=" + roleTag +
                ", atk=" + atk +
                ", name='" + name + '\'' +
                '}';
    }
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

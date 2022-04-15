package com.mou.app.department;

public class Department {
    private String ID;
    private String name;
    private int amount;
    private String responsibility;
    private String manager;

    public void printDetail(){
        System.out.println("部门编号:"+this.ID+"|部门名称:"+this.name+"|部门职责:"+this.responsibility+"|部门人数:"+amount+"人|部门经理:"+this.manager);
    }

    public Department(String ID, String name, int amount, String responsibility, String manager) {
        this.ID = ID;
        this.name = name;
        this.amount = amount;
        this.responsibility = responsibility;
        this.manager = manager;
    }
    public Department(){}

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return String.valueOf(+this.amount);
    }
    public void setAmount(String amount) {
        try { //判断输入是否符合数字条件
            this.amount = Integer.parseInt(amount);
        } catch (NumberFormatException error) {
            this.amount = 0;
        }
    }

    public String getResponsibility() {
        return responsibility;
    }
    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public String getManager() {
        return manager;
    }
    public void setManager(String manager) {
        this.manager = manager;
    }
}

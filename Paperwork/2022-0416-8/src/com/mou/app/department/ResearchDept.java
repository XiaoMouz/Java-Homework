package com.mou.app.department;

public class ResearchDept extends Department{
    private int counts;

    @Override
    public void printDetail() {
        System.out.println("部门编号:"+getID()+"|部门名称:人事部|部门职责:"+getResponsibility()+"|部门人数:"+getAmount()+"人|部门经理:"+getManager()+"|计划招聘:"+getCounts()+"人");
    }

    public void payOff(Department dept){
        System.out.println("已为"+dept.getName()+"的员工发放工资");
    }

    public int getCounts() {
        return counts;
    }
    public void setCounts(String counts) {
        try { //判断输入是否符合数字条件
            this.counts = Integer.parseInt(counts);
        } catch (NumberFormatException error) {
            this.counts = 0;
        }
    }
}

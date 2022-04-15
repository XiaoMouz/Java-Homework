package com.mou.app.department;

public class PersonalDept extends Department{
    private String researchField;

    @Override
    public void printDetail() {
        System.out.println("部门编号:"+getID()+"|部门名称:研发部部|部门职责:"+getResponsibility()+"|部门人数:"+getAmount()+"人|部门经理:"+getManager()+"|研发方向:"+getResearchField());
    }

    public void researching(String field){
        System.out.println("正在研发"+field+"方向");
    }

    public String getResearchField() {
        return researchField;
    }
    public void setResearchField(String researchField) {
        this.researchField = researchField;
    }
}

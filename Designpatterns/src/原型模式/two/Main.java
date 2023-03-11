package 原型模式.two;

public class Main {
    public static void main(String[] args){
        Resume r=new Resume("xx");
        r.setPersonalInfo("男", "20");
        r.setWorkExperience("2020-2030", "XX公司");
        Resume r2=r.clone();
        r2.setWorkExperience("2012-2020","xx企业");
        Resume r3=r.clone();
        r3.setPersonalInfo("女","18");
        r.display();
        r2.display();
        r3.display();
    }
}

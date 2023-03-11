package 原型模式.two;

public class Resume implements Cloneable{
    private String name;
    private String age;
    private String sex;
    private WorkExperience workExperience=new WorkExperience();

    public Resume() {
        super();
    }

    public Resume(String name){
        this.name=name;
    }

    public void setPersonalInfo(String age,String sex){
        this.age = age;
        this.sex = sex;
    }

    public void setWorkExperience(String timeArea,String company){
        workExperience.setTimeArea(timeArea);
        workExperience.setCompany(company);
    }

    public void display(){
        System.out.println("个人介绍："+name+"   "+sex+"   "+age);
        System.out.println("工作经历："+workExperience.getTimeArea()+"   "+workExperience.getCompany());
    }
    public Resume clone(){
        try {
//            调用父类super对象强制转换resume类型
            return (Resume) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

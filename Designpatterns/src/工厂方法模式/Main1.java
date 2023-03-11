package 工厂方法模式;

public class Main1 {
    public static void main(String[] args){
//        LeiFeng lf=SimpleFactory.createLeifeng("学雷锋的大学生");
        IFactory1 iF=new UndergraduateFactory();
        IFactory1 iF1=new VolunteerFactory();
        LeiFeng lf=iF.createLeiFeng();
        LeiFeng lf1=iF1.createLeiFeng();
        lf.getResult();
        lf1.getResult();
    }
}

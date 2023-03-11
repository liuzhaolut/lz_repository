package 装饰者模式;

public class Main {
    public static void main(String[] args){
//        Person p=new Person("xc");
//        p.wearOne();
//        p.show();
//        System.out.println("第一种装扮");
//        WearOne o1=new WearOne();
//        WearTwo t2=new WearTwo();
//        WearThree t3=new WearThree();
//        WearFour f4=new WearFour();
//        o1.decorate(p);
//        t2.decorate(o1);
//        t3.decorate(t2);
//        f4.decorate(t3);
//        f4.show();
//
//        System.out.println();
//        System.out.println("第二种装扮");
//        WearFive f5=new WearFive();
//        WearSix s6=new WearSix();
//        WearSeven s7=new WearSeven();
//        WearEight e8=new WearEight();
//        f5.decorate(p);
//        s6.decorate(f5);
//        s7.decorate(s6);
//        e8.decorate(s7);
//        e8.show();
        ConcreateComponent c=new ConcreateComponent("xx");
        WearOne w1=new WearOne();
        WearTwo w2= new WearTwo();
        w1.setComponent(c);
        w2.setComponent(w1);
        w2.opertion();
    }
}

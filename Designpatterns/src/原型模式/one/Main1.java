package 原型模式.one;

public class Main1 {
    public static void main(String[] args){
        SunWuKong sunWuKong=new SunWuKong("孙悟空");
        SunWuKong sunWuKong11=sunWuKong.clone();
        SunWuKong sunWuKong12=sunWuKong.clone();
        sunWuKong.display();
        sunWuKong11.display();
        sunWuKong12.display();
    }
}

package 代理模式;

public class Main {
    public static void main(String[] args){
        SchoolGirl sg=new SchoolGirl();
        sg.setName("xx");
        Proxy p=new Proxy(sg);
        p.giveDolls();
        p.giveFlowers();
    }
}

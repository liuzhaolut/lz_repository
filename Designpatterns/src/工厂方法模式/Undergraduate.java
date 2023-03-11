package 工厂方法模式;

public class Undergraduate implements LeiFeng{

    public void sweep() {
        System.out.println("洗衣");
    }
    public void wash() {
        System.out.println("做饭");
    }

    public void getResult(){
        Undergraduate u=new Undergraduate();
        u.sweep();
        u.wash();
    }
}

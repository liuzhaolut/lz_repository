package 观察者模式.two;

public class Main {
    public static void main(String[] args){
        Boss b=new Boss();

        // 看股票的人
        StockObserver so1 = new StockObserver("小xx", b);

        // 看NBA的人
        NBAObserver n1 = new NBAObserver("xx", b);

        b.attach(so1);
        b.attach(n1);
//        b.detach(n1);

        // 老板回来
        b.setAction("我回来了！");
        b.announce();
    }
}

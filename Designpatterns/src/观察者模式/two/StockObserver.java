package 观察者模式.two;

public class StockObserver extends Observer{
    public StockObserver(String name,Subject sub){
        super(name,sub);
    }
    @Override
    public void update() {
        System.out.println(sub.getAction()+" "+name+"关闭股票，工作");
    }
}

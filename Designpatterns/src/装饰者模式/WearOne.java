package 装饰者模式;

//public class WearOne extends Finery{
public class WearOne extends Decorator{
//    public void show(){
//        super.show();
//        System.out.println("外套衬衣");
//    }

    public void opertion(){
        super.opertion();
        System.out.println("外套衬衣");
    }
}

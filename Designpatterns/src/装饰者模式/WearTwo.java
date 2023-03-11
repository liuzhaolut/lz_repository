package 装饰者模式;

//public class WearTwo extends Finery{
public class WearTwo extends Decorator{
//    public void show()
//    {
//        super.show();
//        System.out.println("小短袖");
//    }
    public void opertion(){
        super.opertion();
        System.out.println("小短袖");
    }
}

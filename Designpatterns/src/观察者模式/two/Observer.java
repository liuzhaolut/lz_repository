package 观察者模式.two;

public abstract class Observer {
    protected String name;
    protected Subject sub;
    public Observer(String name,Subject sub){
        this.name=name;
        this.sub=sub;
    }
//    发布和订阅
    public abstract void update();
}

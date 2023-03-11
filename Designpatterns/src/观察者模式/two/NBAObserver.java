package 观察者模式.two;

public class NBAObserver extends Observer{
    public NBAObserver(String name,Subject sub){
        super(name,sub);
    }
    @Override
    public void update() {
        System.out.println(sub.getAction()+" "+name+"关闭视频，工作");
    }
}

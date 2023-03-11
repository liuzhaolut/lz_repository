package 观察者模式.two;

public interface Subject {
//    添加
    void attach(Observer observer);
//    删除
    void detach(Observer observer);
//    发布状态
    void announce();
//    设定老板信息
    String getAction();
    void setAction(String action);
}

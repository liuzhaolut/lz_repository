package 观察者模式.two;

import java.util.ArrayList;
import java.util.List;

public class Secretary implements Subject{
    private List<Observer>
            observers	= new ArrayList<Observer>();
    private String action;
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void announce() {
        for(Observer obj:observers){
            obj.update();
        }
    }

    @Override
    public String getAction() {
        return action;
    }

    @Override
    public void setAction(String action) {
        this.action=action;
    }
}

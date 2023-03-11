package 装饰者模式;

public class Finery extends Person{
    protected  Person component;
    public void decorate(Person component){
        this.component=component;
    }
    public void show(){
        if(null!=component){
            component.show();
        }
    }
}

package 装饰者模式;

public class Decorator implements Component{
    protected Component component;

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public void opertion() {
        if(null!=component){
            component.opertion();
        }
    }
}

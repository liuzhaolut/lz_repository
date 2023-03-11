package 工厂方法模式;

public class AddFactory implements IFactory{
    @Override
    public Operation createOpertation() {
        return new OpertationAdd();
    }
}

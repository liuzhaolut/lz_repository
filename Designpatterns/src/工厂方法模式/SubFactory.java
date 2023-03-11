package 工厂方法模式;

public class SubFactory implements IFactory{
    public Operation createOpertation() {
        return new OpertationSub();
    }
}

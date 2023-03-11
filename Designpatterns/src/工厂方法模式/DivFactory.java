package 工厂方法模式;

public class DivFactory implements IFactory{
    public Operation createOpertation() {
        return new OpertationDiv();
    }
}

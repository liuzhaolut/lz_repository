package 工厂方法模式;

public class MulFactory implements IFactory{
    public Operation createOpertation() {
        return new OpertationMul();
    }
}

package 工厂方法模式;

public class UndergraduateFactory implements IFactory1{

    @Override
    public LeiFeng createLeiFeng() {
        return new Undergraduate();
    }
}

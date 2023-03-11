package 工厂方法模式;

public class VolunteerFactory implements IFactory1{
    @Override
    public LeiFeng createLeiFeng() {
        return new Volunteer();
    }
}

package 外观模式;

public class Realty1 implements Fund{

    @Override
    public void buyFund() {
        System.out.println("房产1买入");
    }

    @Override
    public void sellFund() {
        System.out.println("房产1卖出");
    }
}

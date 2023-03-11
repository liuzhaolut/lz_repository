package 外观模式;

public class Realty2 implements Fund{

    @Override
    public void buyFund() {
        System.out.println("房产2买入");
    }

    @Override
    public void sellFund() {
        System.out.println("房产2卖出");
    }
}

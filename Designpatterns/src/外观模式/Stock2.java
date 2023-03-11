package 外观模式;

public class Stock2 implements Fund{

    @Override
    public void buyFund() {
        System.out.println("股票2买入");
    }

    @Override
    public void sellFund() {
        System.out.println("股票2卖出");
    }
}

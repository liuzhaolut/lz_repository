package 外观模式;

public class Stock1 implements Fund{

    @Override
    public void buyFund() {
        System.out.println("股票1买入");
    }

    @Override
    public void sellFund() {
        System.out.println("股票1卖出");
    }
}

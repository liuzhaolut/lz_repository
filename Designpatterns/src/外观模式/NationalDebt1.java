package 外观模式;

public class NationalDebt1 implements Fund{

    @Override
    public void buyFund() {
        System.out.println("国债1买入");
    }

    @Override
    public void sellFund() {
        System.out.println("国债1卖出");
    }
}

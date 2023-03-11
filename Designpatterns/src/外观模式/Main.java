package 外观模式;

public class Main {
    public static void main(String[] args)
    {
        Fund gp= new Stock1();
        gp.buyFund();
        gp.sellFund();
        Fund gz= new NationalDebt1();
        gz.buyFund();
        gz.sellFund();
        Fund fc= new Realty1();
        fc.sellFund();
        fc.buyFund();
    }
}

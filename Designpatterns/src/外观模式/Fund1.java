package 外观模式;

public class Fund1 {
    Stock1	one;
    Stock2	two;
    NationalDebt1	three;
    NationalDebt2	four;
    Realty1 five;
    Realty2 six;

    public Fund1()
    {
        one = new Stock1();
        two = new Stock2();
        three = new NationalDebt1();
        four = new NationalDebt2();
        five = new Realty1();
        six = new Realty2();
    }

    public void methodA()
    {
        System.out.println("方法组A");
        one.buyFund();
        two.sellFund();
        four.buyFund();
    }

    public void methodB()
    {
        System.out.println("方法组B");
        five.buyFund();
        six.sellFund();
    }
}

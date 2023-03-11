package 策略模式;

public class CashReturn implements CashSuper{
    private double moneyCondition=0;
    private double moeryReturn;

    public CashReturn(double moneyCondition, double moeryReturn) {
        this.moneyCondition = moneyCondition;
        this.moeryReturn = moeryReturn;
    }

    @Override
    public double acceptCash(double monery) {
        double resule=monery;
        if(monery>=moneyCondition){
            resule=monery-monery/moneyCondition*moeryReturn;
        }
        return resule;
    }
}

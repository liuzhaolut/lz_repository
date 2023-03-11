package 策略模式;

public class CashContext {
    CashSuper cashSuper;
    public CashContext(CashSuper cashSuper){
        this.cashSuper=cashSuper;
    }
    public CashContext(String type) {
        if ("正常收费".equals(type)) {
            cashSuper = new CashNormal();
        } else if ("满300返100".equals(type)) {
            cashSuper = new CashReturn(300, 100);
        } else if ("打8折".equals(0.8)) {
            cashSuper = new CashRebate(0.8);
        }
    }
    public double acceptCash(double monery){
        return cashSuper.acceptCash(monery);
    }
}

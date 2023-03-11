package 策略模式;

public class CashFactory {
    public static CashSuper createCash(String type){
        CashSuper cashSuper=null;
        if("正常收费".equals(type)){
            cashSuper=new CashNormal();
        }else if ("满300返100".equals(type)){
            cashSuper=new CashReturn(300,100);
        }else if ("打8折".equals(type)){
            cashSuper=new CashRebate(0.8);
        }
        return cashSuper;
    }
}

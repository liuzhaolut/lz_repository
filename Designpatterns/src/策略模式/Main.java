package 策略模式;

public class Main {
    private static double total=0;
    public static void main(String[] args){
        consume("正常收费",1,1000);
        consume("满300返100",1,1000);
        consume("打8折",1,1000);
    }

    private static void consume(String type, int num, double price) {
        CashSuper cashSuper=CashFactory.createCash(type);
        double totalPrice=cashSuper.acceptCash(num * price);
        total+=totalPrice;
        System.out.println("单价："+price);
        System.out.println("数量："+num);
        System.out.println("总计："+totalPrice);
    }
}

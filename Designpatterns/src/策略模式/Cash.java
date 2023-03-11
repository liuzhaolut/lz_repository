package 策略模式;

public class Cash {
    private double total=0;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void sumbit(int num, double price, double discount){
        double totalPrice=num*price;
        total+=totalPrice;
        System.out.println("数量为："+num+"   "+"单价为："+price);
        System.out.println("折扣为："+discount);
        System.out.println("合计为："+total);
    }
}

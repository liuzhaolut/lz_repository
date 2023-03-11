package 工厂方法模式;

public class OpertationDiv extends Operation {
    public double getResult(){
        double result = 0;
        if (getNumberB() != 0) {
            result = getNumberA() / getNumberB();
        } else {
            return -1;
        }
        return result;
    }
}

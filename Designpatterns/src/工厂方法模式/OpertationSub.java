package 工厂方法模式;

public class OpertationSub extends Operation {
    public double getResult() {
        double result = 0;
        result = getNumberA() - getNumberB();
        return result;
    }
}

package 状态模式;

public class RestState implements State {
    public void writeProgram(Work work)
    {
        System.out.println("当前时间：" + work.getHour() + "点 下班回家了");
    }
}

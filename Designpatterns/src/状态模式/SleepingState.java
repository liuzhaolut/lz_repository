package 状态模式;

public class SleepingState implements State {
    public void writeProgram(Work work)
    {
        System.out.println("当前时间：" + work.getHour() + "点 扛不住了，睡着了");
    }
}

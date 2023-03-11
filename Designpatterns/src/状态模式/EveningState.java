package 状态模式;

public class EveningState implements  State {
    public void writeProgram(Work work)
    {
        if (work.isFinish())
        {
            work.setState(new RestState());
            work.writeProgram();
        }
        else
        {
            if (work.getHour() < 21)
            {
                System.out.println("当前时间：" + work.getHour() + "点 加班啊，疲惫至极");
            }
            else
            {
                work.setState(new SleepingState());
                work.writeProgram();
            }
        }
    }
}

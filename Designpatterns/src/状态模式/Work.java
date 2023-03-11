package 状态模式;

public class Work {
    private int	hour;
    private boolean	finish	= false;
    private State state;
    public Work()
    {
        state = new ForenoonState();
    }

    public void writeProgram()
    {
        state.writeProgram(this);
    }
//
//    public void writeProgram()
//    {
//        if (hour < 12)
//        {
//            System.out.println("当前时间：" + hour + "点 上午工作，精神百倍");
//        }
//        else if (hour < 13)
//        {
//            System.out.println("当前时间：" + hour + "点 饿了，午饭，犯困，午休");
//        }
//        else if (hour < 17)
//        {
//            System.out.println("当前时间：" + hour + "点 下午状态还不错，继续努力");
//        }
//        else
//        {
//            if (finish)
//            {
//                System.out.println("当前时间：" + hour + "点 下班回家了");
//            }
//            else
//            {
//                if (hour < 21)
//                {
//                    System.out.println("当前时间：" + hour + "点 加班啊，疲惫至极");
//                }
//                else
//                {
//                    System.out.println("当前时间：" + hour + "点 扛不住了，睡着了");
//                }
//            }
//        }
//    }
//
    public int getHour()
    {
        return hour;
    }

    public void setHour(int hour)
    {
        this.hour = hour;
    }

    public boolean isFinish()
    {
        return finish;
    }

    public void setFinish(boolean finish)
    {
        this.finish = finish;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

package 状态模式;

public class ForenoonState implements  State {
    public void writeProgram(Work work) {
        if (work.getHour() < 12) {
            System.out.println("当前时间：" + work.getHour() + "点 上午工作，精神百倍");
        } else {
            work.setState(new AfternoonState());
            work.writeProgram();
        }
    }
}

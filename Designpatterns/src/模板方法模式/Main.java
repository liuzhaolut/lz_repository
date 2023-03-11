package 模板方法模式;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("学生A抄的试卷：");
        TestPaperA studentA = new TestPaperA();
        studentA.testQuestion1();
        studentA.testQuestion2();
        studentA.testQuestion3();

        System.out.println("学生B抄的试卷：");
        TestPaperA studentB = new TestPaperA();
        studentB.testQuestion1();
        studentB.testQuestion2();
        studentB.testQuestion3();
    }
}

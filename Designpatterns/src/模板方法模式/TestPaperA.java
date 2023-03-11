package 模板方法模式;

public class TestPaperA extends TestPaper{
//    public void testQuestion1()
//    {
////        System.out.println("我喜欢吃什么[] "
////                + "a.火锅 b.麻辣烫 c.干锅 d.米线");
//        super.testQuestion1();
//        System.out.println("答案:a");
//    }
//
//    public void testQuestion2()
//    {
////        System.out.println("我喜欢的颜色[] " + "a.红 b.蓝 "
////                + "c.黑 d.紫");
//        super.testQuestion2();
//        System.out.println("答案:d");
//    }
//
//    public void testQuestion3()
//    {
////        System.out.println("我喜欢看的视频[] "
////                + "a.电影 b.韩剧 c.动漫d.电视剧 e.综艺");
//        super.testQuestion3();
//        System.out.println("答案:c");
//    }

    protected String answer1()
    {
        return "a";
    }

    protected String answer2()
    {
        return "d";
    }

    protected String answer3()
    {
        return "c";
    }
}

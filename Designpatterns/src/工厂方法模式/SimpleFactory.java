package 工厂方法模式;

public class SimpleFactory {
    public static LeiFeng createLeifeng(String type){
        LeiFeng result=null;
        if("学雷锋的大学生".equals(type)){
            result=new Undergraduate();
        }else if("社区服务者".equals(type)) {
            result = new Volunteer();
        }
        return result;
    }
}

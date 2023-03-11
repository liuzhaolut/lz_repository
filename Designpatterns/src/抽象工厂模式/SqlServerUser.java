package 抽象工厂模式;

public class SqlServerUser implements IUser{
    public void insert(User user){
        System.out.println("在SQL server中给user表添加一条记录");
    }
    public User getUser(int id){
        System.out.println("在SQL server中根据ID得到User表一条记录");
        return null;
    }
}

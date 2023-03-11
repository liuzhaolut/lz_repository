package 抽象工厂模式;

public class AccessUser implements IUser {
    @Override
    public void insert(User user) {
        System.out.println("在Access中给user表添加一条记录");
    }

    @Override
    public User getUser(int id) {
        System.out.println("在Access中根据ID得到User表一条记录");
        return null;
    }
}

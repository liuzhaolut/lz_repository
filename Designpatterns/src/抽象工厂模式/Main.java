package 抽象工厂模式;

public class Main {
    public static void main(String[] args){
        User user=new User();
        Department department=new Department();
//        IFactory factory=new SqlServerFactory();
//        IFactory iFactory=new AccessFactory();
//        SqlServerUser su=new SqlServerUser();
        IUser iUser=DataAccess.createUser();
        iUser.insert(user);
        iUser.getUser(1);
        IDepartment iDepartment=DataAccess.createDepartment();
        iDepartment.insert(department);
        iDepartment.getDepartment(1);
    }
}

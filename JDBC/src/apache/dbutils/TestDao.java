package apache.dbutils;

import java.util.List;

public class TestDao {
    public static void main(String[] args) {
        Dao dao = new DaoImpl();
        User user = new User();
        user.setUsername("dtww");
        user.setPassword("dtxxww");
        user.setAddress("乌漆嘛黑，呼哩哗啦");
        user.setPhone("12552163944");
//        测试新增
//        int count = dao.addUser(user);
//        if (count >= 1) {
//            System.out.println("插入成功： " + count + " 条");
//        } else {
//            System.out.println("插入失败");
//        }
//        测试删除
//        int count = dao.deleteUser(user);
//        if (count >= 1) {
//            System.out.println("删除成功： " + count + " 条");
//        } else {
//            System.out.println("删除失败");
//        }
//        测试修改
//        user.setAddress("xl");
//        int count1 = dao.updateUser(user);
//        if (count1>= 1) {
//            System.out.println("更新成功： " + count1 + " 条");
//        } else {
//            System.out.println("更新失败");
//        }
//        测试查询一人
//        User user1 = dao.selectOne(user);
//        System.out.println(user1.toString());
//        System.out.println("-------------------------------------");
////        测试查询全部
//        List<User> users = dao.selectAll();
//        for (User u:users
//             ) {
//            System.out.println(u.toString());
//        }
//        演示人数
        long l = dao.selectUserNum();
        System.out.println(l);
    }
}
